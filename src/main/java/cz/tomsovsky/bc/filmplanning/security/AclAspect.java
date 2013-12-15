package cz.tomsovsky.bc.filmplanning.security;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.core.context.SecurityContextHolder;

import cz.tomsovsky.bc.filmplanning.dto.IDomain;

/**
 * Aspektová třída, která obsahuje advice metody pro operace s ACL.
 * 
 * @author Martin Tomšovský
 */
@Aspect
public class AclAspect {
	@Autowired
	private MutableAclService aclService;
	
	@After("execution(* cz.tomsovsky.bc.filmplanning.repository.impl.*.save(..)) &&" +
			"args(cz.tomsovsky.bc.filmplanning.dto.IAclDomain)")
	public void createAcl(final JoinPoint jp) {
		IDomain domain = extractDto(jp);
		if (domain == null)
			return;
		List<Permission> permissions = new ArrayList<Permission>();
		permissions.add(BasePermission.ADMINISTRATION);
		createAcl(domain, permissions);
	}
	
	@After("execution(* cz.tomsovsky.bc.filmplanning.repository.impl.*.delete(..)) &&" +
			"args(cz.tomsovsky.bc.filmplanning.dto.IAclDomain)")
	public void deleteAcl(final JoinPoint jp) {
		IDomain domain = extractDto(jp);
		if (domain == null)
			return;
		aclService.deleteAcl(new ObjectIdentityImpl(domain.getClass(), domain.getId()), true);
	}
	
	private void createAcl(IDomain domain, List<Permission> permissions) {
		ObjectIdentity oi = new ObjectIdentityImpl(domain.getClass(), domain.getId());
		Sid sid = new PrincipalSid(SecurityContextHolder.getContext().getAuthentication());
		
		if (findAcl(oi) == null) {
			MutableAcl acl = aclService.createAcl(oi);
			for (Permission p : permissions) {
				acl.insertAce(acl.getEntries().size(), p, sid, true);
			}
			aclService.updateAcl(acl);
		}
	}
	
	private MutableAcl findAcl(ObjectIdentity oi) {
		MutableAcl acl = null;
		try {
			acl = (MutableAcl) aclService.readAclById(oi);
		}
		catch (NotFoundException ex) {
			return null;
		}
		return acl;
	}
	
	private IDomain extractDto(final JoinPoint jp) {
		Object[] args = jp.getArgs();
		IDomain domain = null;
		for(int i=0; i<args.length; i++) {
			if (args[i] instanceof IDomain) {
				domain = (IDomain) args[i];
				break;
			}
		}
		return domain;
	}

	public MutableAclService getAclService() {
		return aclService;
	}

	public void setAclService(MutableAclService aclService) {
		this.aclService = aclService;
	}
}

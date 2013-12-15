package cz.tomsovsky.bc.filmplanning.security;

import org.springframework.security.acls.model.Permission;

import javax.sql.DataSource;

import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.acls.jdbc.LookupStrategy;
import org.springframework.security.acls.model.AclCache;
import org.springframework.security.acls.model.Sid;

public class JdbcMutableAclWithClassEntryService extends JdbcMutableAclService {
	private String insertClassEntry = "insert into acl_class_entry "
	        + "(class, sid, filmproject_id, permission)"
	        + "values (?, ?, ?)";
	
	public JdbcMutableAclWithClassEntryService(DataSource dataSource,
			LookupStrategy lookupStrategy, AclCache aclCache) {
		super(dataSource, lookupStrategy, aclCache);
	}
	
	public void createClassEntries(Class<?> javaType, Sid sid, long filmProjectId, Permission p) {
		Long sidId = createOrRetrieveSidPrimaryKey(sid, true);
        Long classId = createOrRetrieveClassPrimaryKey(javaType.getName(), true);
        jdbcTemplate.update(insertClassEntry, classId, sidId, filmProjectId, p.getMask());
	}
}

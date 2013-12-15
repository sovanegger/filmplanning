package cz.tomsovsky.bc.filmplanning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.tomsovsky.bc.filmplanning.dto.Authority;
import cz.tomsovsky.bc.filmplanning.repository.AuthorityDao;
import cz.tomsovsky.bc.filmplanning.service.AuthorityService;

/**
 * Servisní třída entity <code>Authority</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="authorityService")
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	private AuthorityDao authorityDao;

	@Override
	@Transactional
	public List<Authority> getAllAuthorities() {
		return authorityDao.list();
	}

	@Override
	@Transactional
	public void saveAuthority(Authority authority) {
		authorityDao.save(authority);

	}

	@Override
	@Transactional
	public void updateAuthority(Authority authority) {
		authorityDao.update(authority);
	}

	@Override
	@Transactional
	public Authority getAuthorityById(long id) {
		return authorityDao.getById(id);
	}

	@Override
	@Transactional
	public void deleteAuthority(long id) {
		Authority authority = authorityDao.getById(id);
		authorityDao.delete(authority);
	}

	@Override
	@Transactional
	public void deleteAuthority(Authority authority) {
		authorityDao.delete(authority);
	}
	
	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}
}

package cz.tomsovsky.bc.filmplanning.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

/**
 * Vlastní implementace <code>AuthenticationManageru</code>, která byla vytvořena pro účely
 * administračního rozhraní. Dědí však od springovské třídy <code>ProviderManager</code>,
 * který je použita pro klasickou autentizaci.
 * 
 * @author Martin Tomšovský
 */
public class AdminProviderManager extends ProviderManager implements AuthenticationManager {
	private List<AuthenticationProvider> providers = Collections.emptyList();
	
	public AdminProviderManager(List<AuthenticationProvider> providers) {
		super(providers);
		this.providers = providers;
	}
	
	// TODO delegovat činnost autentizace na AuthenticationProvider
	/**
	 * Hlavní metoda, která rozhoduje, je-li objekt autentizován.
	 * 
	 * @param authentication objekt, který má projít autentizací
	 * @return result pokud je objekt autentizovaný, vrátí metoda nový autentizační objekt,
	 * pokud ne, vrátí null
	 */
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		Authentication result = super.authenticate(authentication);
		Collection<? extends GrantedAuthority> authorities = result.getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("ROLE_ADMIN"))
				return result;
		}
		return null;
	}
	
	public List<AuthenticationProvider> getProviders() {
		return providers;
	}
}
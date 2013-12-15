package cz.tomsovsky.bc.filmplanning.repository.impl;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.beanvalidation.BeanValidationEventListener;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateEventWiring {
	private SessionFactory sessionFactory;
	private BeanValidationEventListener beanValidationEventListener;
	
	@Autowired
	public HibernateEventWiring(SessionFactory sessionFactory, BeanValidationEventListener beanValidationEventListener) {
		this.sessionFactory = sessionFactory;
		this.beanValidationEventListener = beanValidationEventListener;
	}

	@PostConstruct
	public void registerListeners() {
	    EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
	            EventListenerRegistry.class);
	    
	    registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(beanValidationEventListener);
	    registry.getEventListenerGroup(EventType.PRE_DELETE).appendListener(beanValidationEventListener);
	    registry.getEventListenerGroup(EventType.PRE_UPDATE).appendListener(beanValidationEventListener);
	}
}
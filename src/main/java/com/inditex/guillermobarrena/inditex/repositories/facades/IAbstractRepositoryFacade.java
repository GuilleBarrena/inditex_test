package com.inditex.guillermobarrena.inditex.repositories.facades;

public abstract class IAbstractRepositoryFacade <DOMAIN, ENTITY> {
    protected abstract DOMAIN convertEntityToDomain(ENTITY entity);
    protected abstract ENTITY convertDomainToDomain(DOMAIN domain);
}

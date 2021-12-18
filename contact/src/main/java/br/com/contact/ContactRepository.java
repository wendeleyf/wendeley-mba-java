package br.com.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //interface managed by spring
public interface ContactRepository extends JpaRepository<Contact, Long> {
    public Contact findByName(String name);
}

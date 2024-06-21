package umc.week9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.week9.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}

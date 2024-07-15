package com.dera.appli_hub.repository;

import com.dera.appli_hub.domain.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileData, Long> {
    Optional<FileData> findByName(String filename);
}

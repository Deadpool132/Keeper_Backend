package com.keeper.app.KeeperApp.repository;

import com.keeper.app.KeeperApp.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
}

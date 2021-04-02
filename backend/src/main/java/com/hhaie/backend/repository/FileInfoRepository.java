package com.hhaie.backend.repository;


import com.hhaie.backend.model.files.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileInfoRepository extends JpaRepository<FileInfo, String> {

    boolean existsByFilenameAndContextId(String filename, String contextId);

    Optional<FileInfo> findByIdAndContextId(String fileId, String contextId);

    void deleteByFilenameAndContextId(String filename, String contextId);

    List<FileInfo> findAllByIdInAndContextId(List fileIds, String contextId );

    List<FileInfo> findAllByContextId(String contextId);
}
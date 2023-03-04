package com.ticketapp.sfmoviehouse.repository;

import com.ticketapp.sfmoviehouse.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//credit to Bezkoder at https://www.bezkoder.com/spring-boot-upload-file-database/
@Repository
public interface FileRepository extends JpaRepository<File, String> {

}

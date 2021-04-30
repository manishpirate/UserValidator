package com.example.roomservice.db.repository;

import com.example.roomservice.db.entity.Room;
import org.springframework.data.repository.CrudRepository;

//Crud repository is the base repository and is actually a marker interface. Allows operations like
//findOne and gets
public interface RoomRepository extends CrudRepository<Room, Long>  {

}

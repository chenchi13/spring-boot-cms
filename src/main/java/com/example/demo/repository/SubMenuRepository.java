package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.MainMenu;
import com.example.demo.model.SubMenu;

@Component
public interface SubMenuRepository extends JpaRepository<SubMenu, Long>{

	List<SubMenu> findByMainMenu(MainMenu item);

}

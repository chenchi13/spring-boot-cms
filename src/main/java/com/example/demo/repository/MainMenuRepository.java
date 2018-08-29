package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.MainMenu;

@Component
public interface MainMenuRepository extends JpaRepository<MainMenu, Long>{

	MainMenu findByLabel(String string);

}

package com.example.demo.general.book.graph;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuildOrderTest {

	@Test
	@DisplayName("Given projects that can be built when getting build order should return correct order")
	void givenProjectsThatCanBeBuilt_whenGettingBuildOrder_shouldReturnCorrectOrder() {
		// Given
		List<BuildOrder.Dependency> dependencies = new ArrayList<>();
		dependencies.add( new BuildOrder.Dependency("a", "d") );
		dependencies.add( new BuildOrder.Dependency("b", "d") );
		dependencies.add( new BuildOrder.Dependency("f", "b") );
		dependencies.add( new BuildOrder.Dependency("f", "a") );
		dependencies.add( new BuildOrder.Dependency("d", "c") );

		// When
		List<BuildOrder.Project> projects = BuildOrder.get( dependencies );

		// Then
		assertThat(projects).isEmpty();
	}

	@Test
	@DisplayName("Given projects that can be built when getting build order should return correct order")
	void givenProjectsThatCanBeBuilt_whenGettingBuildOrder_shouldReturnCorrectOrder2() {
		// Given
		List<BuildOrder.Dependency> dependencies = new ArrayList<>();
		dependencies.add( new BuildOrder.Dependency("f", "c") );
		dependencies.add( new BuildOrder.Dependency("f", "b") );
		dependencies.add( new BuildOrder.Dependency("f", "a") );
		dependencies.add( new BuildOrder.Dependency("c", "a") );
		dependencies.add( new BuildOrder.Dependency("b", "a") );
		dependencies.add( new BuildOrder.Dependency("b", "e") );
		dependencies.add( new BuildOrder.Dependency("a", "e") );
		dependencies.add( new BuildOrder.Dependency("d", "g") );

		// When
		List<BuildOrder.Project> projects = BuildOrder.get( dependencies );

		// Then
		assertThat(projects).extracting( BuildOrder.Project::getName ).isEmpty();
	}

}
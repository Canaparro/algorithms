package com.example.demo.general.book.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BuildOrder {

	public static Stack<Project> get( List<Dependency> dependencies ) {
		Map<String, Project> graph = buildGraph( dependencies );

		return getBuildOrder( graph.values() );
	}



	private static Stack<Project> getBuildOrder( final Collection<Project> projects ) {
		Stack<Project> stack = new Stack<>();

		for ( final Project project : projects ) {
			if(project.state == State.BLANK) {
				if(!doDFS(project, stack)) {
					return null;
				}
			}
		}
		return stack;
	}

	private static boolean doDFS( final Project project, final Stack<Project> stack ) {
		if(project.state == State.PARTIAL) {
			return false;
		}

		if(project.state == State.BLANK) {
			project.state = State.PARTIAL;
			for ( final Project depedency : project.depedencies ) {
				if(!doDFS( depedency, stack )) {
					return false;
				}
			}
			project.state = State.COMPLETE;
			stack.push( project );
		}

		return true;
	}

	private static Map<String, Project> buildGraph( final List<Dependency> dependencies ) {
		Map<String, Project> projectMap = new HashMap<>();

		for ( final Dependency dependency : dependencies ) {
			Project project = getProjectByName( projectMap, dependency.projectName );
			Project projectDependency = getProjectByName( projectMap,
					dependency.projectDependencyName );
			project.depedencies.add( projectDependency );
		}
		return projectMap;
	}

	private static Project getProjectByName( final Map<String, Project> projectMap,
			final String projectName ) {
		Project project = projectMap.get( projectName );
		if ( project == null ) {
			project = new Project( projectName );
		}
		projectMap.putIfAbsent( projectName, project );
		return project;
	}

	static class Dependency {
		String projectDependencyName;
		String projectName;

		public Dependency( final String projectDependencyName, final String projectName ) {
			this.projectDependencyName = projectDependencyName;
			this.projectName = projectName;
		}
	}

	static class Project {
		String name;
		Set<Project> depedencies;
		State state = State.BLANK;

		public Project( final String name ) {
			this.name = name;
			this.depedencies = new HashSet<>();
		}

		public String getName() {
			return name;
		}

		public Set<Project> getDepedencies() {
			return depedencies;
		}
	}

	enum State {COMPLETE, PARTIAL, BLANK}
}

package edu.mum.mumscrum.common;

public class ConfigurationConstants {
	public interface ErrorMessage {
		public final static String ORACLE_DRIVE_CLASS_NOT_FOUND_EXCEPTION = "Class not found exception - Oracle Drive";
		public final static String SQL_EXCEPTION = "SQL Exception";
		public final static String JSON_EXCEPTION = "JSON Exception ";
		public final static String SUCCESS = "ok";
		public final static String FAIL = "fail";
		public final static String USERNAME_OR_PASSWORD_VALUE_IS_REQUIRED = "Username/Password value is required";
		public final static String INVALID_USERNAME_OR_PASSWORD = "Invalid Username/Password";
		public final static String AUTHENTICATION_FAILED = "Authentication Failed";
	}

	public interface AuthenticationStandard {
		public final static String BASIC = "Basic";
	}

	public interface CharacterEncoding {
		public final static String UTF_8 = "UTF-8";
	}

	public enum SortingType {

		DESCENDING(1, "Descending"), ASCENDING(2, "Ascending");

		private int id;
		private String name;

		private SortingType(int id, String name) {
			this.name = name;
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public enum RoleTypeHomeRoute {

		PRODUCT_OWNER(1, "Product Owner", "/product"), SCRUM_MASTER(2,
				"Scrum Master", "/sprint"), DEVELOPER(3, "Developer",
				"/userstory/assignee"), TESTER(4, "Tester",
				"/userstory/assignee"), HR_ADMIN(5, "HR Admin", "/employee");

		private int id;
		private String name;
		private String homeRoute;

		private RoleTypeHomeRoute(int id, String name, String homeRoute) {
			this.name = name;
			this.id = id;
			this.homeRoute = homeRoute;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getHomeRoute() {
			return homeRoute;
		}

		public void setHomeRoute(String homeRoute) {
			this.homeRoute = homeRoute;
		}
	}

	public interface ProgressRecordStateFlag {
		public final static long DEFAULT = 0;
		public final static long START = 1;
		public final static long STOP = 2;
	}

	public interface UserStoryStateFlag {
		public final static long START = 1;
		public final static long STOP = 2;
	}

}

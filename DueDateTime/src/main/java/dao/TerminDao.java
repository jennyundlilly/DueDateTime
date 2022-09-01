package dao;

public abstract class TerminDao {
	private String terminFilePath = "src/main/resources/data/kontakts.nguyen";

	public TerminDao() {
		System.out.println("Constructor TerminDao");
	}

	public String getTerminFilePath() {
		return terminFilePath;
	}

}

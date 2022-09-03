package dao;

public abstract class TerminDao {
	private String terminFilePath = "src/main/resources/data/kontakts.nguyen";

	public TerminDao() {
	}

	public String getTerminFilePath() {
		return terminFilePath;
	}

}

package genericUtilities;

/**
 * This interface contains external file paths and JDBC URL
 * 
 * @author sncsr
 *
 */
public interface IConstantPath {

	String PROPERTIES_FILE_PATH = System.getProperty("user.dir") +
			"/src/test/resources/testData/commondata.properties";
	String EXCEL_PATH = System.getProperty("user.dir") + 
			"/src/test/resources/testData/SkillRaryTestData.xlsx";
}

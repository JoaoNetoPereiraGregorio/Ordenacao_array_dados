package Prova;


public class Item {
    private String gender;
    private String race;
    private String parentalLevelEducation;
    private String lunch;
    private String testPreparation;
    private int mathScore;
    private int readScore;
    private int writeScore;

  
    public Item(String gender, String race, String parentalLevelEducation, String lunch, String testPreparation, int mathScore, int readScore, int writeScore) {
        this.gender = gender;
        this.race = race;
        this.parentalLevelEducation = parentalLevelEducation;
        this.lunch = lunch;
        this.testPreparation = testPreparation;
        this.mathScore = mathScore;
        this.readScore = readScore;
        this.writeScore = writeScore;
    }

    

    public Item(String[] tokens) {
        gender = tokens[0].replaceAll("\"", "");;
        race = tokens[1].replaceAll("\"", "");;
        parentalLevelEducation = tokens[2].replaceAll("\"", "");;
        lunch = tokens[3].replaceAll("\"", "");;
        testPreparation = tokens[4].replaceAll("\"", "");;
    //    mathScore = tokens[5].replaceAll("\"", "");;
        mathScore= Integer.parseInt(tokens[5].replaceAll("\"", ""));
        readScore = Integer.parseInt(tokens[6].replaceAll("\"", ""));;
        writeScore =Integer.parseInt( tokens[7].replaceAll("\"", ""));;
       
    }

    public String getTestPreparation() {
        return testPreparation;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public String getParentalLevelEducation() {
        return parentalLevelEducation;
    }

    public String getLunch() {
        return lunch;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getReadScore() {
        return readScore;
    }

    public int getWriteScore() {
        return writeScore;
    }



	@Override
	public String toString() {
		return "Item [gender=" + gender + ", race=" + race + ", parentalLevelEducation=" + parentalLevelEducation
				+ ", lunch=" + lunch + ", testPreparation=" + testPreparation + ", mathScore=" + mathScore
				+ ", readScore=" + readScore + ", writeScore=" + writeScore + "]";
	}

//	@Override
//	public String toString() {
//		return "Item [mathScore=" + mathScore;
//	}
    
    

   
}

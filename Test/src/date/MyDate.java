package date;

public class MyDate {
    private int day;
    private int month;
    private int year;

    /**
     * Constructs a date.
     *
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     */
    public MyDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    
    /**
     * Determines if a given (day, month, year) represents a valid date.
     *
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     * @return true if (day, month, year) represents a valid date, false else
     */
    public static boolean isValidDate(int day, int month, int year) {
        return checkData(day, month, year);
    }

    /**
     * Determines if a given (day, month, year) represents a valid date.
     *
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     * @return true if (day, month, year) represents a valid date, false else
     */
    private static boolean checkData(int day, int month, int year) {
        return checkDay(day) && checkMonth(month) && checkYear(year)
            && checkDayLimits(day, month, year);
    }

    /**
     * Determines if this object represents a valid date.
     *
     * @return true if this object represents a valid date, false else
     */
    public boolean checkData() {
        return checkData(day, month, year);
    }

    /**
     * Get the last day given a month and a year.
     *
     * @param      month   the month.
     * @param      year   the year.
     * @return the last day of (month, year), (should be 28, 29, 30 or 31)
     */
    public static int maxDayOfMonth(int month, int year) {
        int result = 31;
        if ( month == 2 ){
        	if(year%4 == 0){
        		if (year%100 == 0){
        			result = 28;
        		}
        		else{
        			result = 29;
        		}
        		if (year%400 == 0){
        			result = 29;
        		}
        	}
        	else{
        		result = 28;
        	}
        }
        
            
        if ( month == 4 || month == 6 || month == 9 || month == 11 ){
            result = 30;
        }
        return result;
    }    

    /**
     * Updates the day, month and year) attributes of this object
     * to the next day (tomorrow).
     *
     * @return this (my)date
     */
    public MyDate nextDay() {
    	if(!(this.checkData())){
    		System.out.println("MyDate: "+this.getDay()+"/"+this.getMonth()+"/"+this.getYear()+" is not a valid date");
    		this.setDay(0);
    		this.setYear(0);
    		this.setMonth(0);
    		return this;
    	}
    	this.setDay(this.day + 1);
    	if(!(this.checkData())){
    		this.setDay(1);
    		this.setMonth(this.month + 1);
    	}
    	if(!(this.checkData())){
    		this.setMonth(1);
    		this.setYear(this.year + 1);
    	}
    	if(!(this.checkData())){
    		System.out.println("WARNING: bound limit overpassed. MyDate: "+this.getDay()+"/"+this.getMonth()+"/"+this.getYear()+" is not more a valid date");
    	}
        return this;
    }
    
    /**
     * Allocates a <code>MyDate</code> object and initializes it to represent
     * the day (tomorrow) which follows the provided day, month and year.
     *
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     * @return a (my)date object initialized to next day of (day, month, year)
     */
    public static MyDate nextDay(int day, int month, int year) {
        MyDate date = new MyDate(day, month, year);
        return date.nextDay();
    }
    
    private static boolean checkDayLimits(int day, int month, int year) {
        return day<=maxDayOfMonth(month,year);
    }

    private static boolean checkDay(int day) {
        return day > 0 && day < 32;
    }

    private static boolean checkMonth(int month) {
        return month > 0 && month < 13;
    }

    private static boolean checkYear(int year) {
        return year >=1 && year < 4001;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    private void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    private void setMonth(int month) {
        this.month = month;
    }

    public static void main(String args[]) {
      System.out.println("MyDate");
    }
    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}
    
    
    
    // Overriding equals() to compare two MyDate objects
    @Override
    public boolean equals(Object obj) {
    	
    	//If there is nothing in obj, don't even bother to compare
    	if (obj == null) {
            return false;
        }
 
        // If the object is compared with itself then return true  
        if (obj == this) {
            return true;
        }
 
        /* Check if obj is an instance of MyDate or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof MyDate)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members 
        MyDate c = (MyDate) obj;
         
        // Compare the data members and return accordingly 
        return c.day==this.day && c.month==this.month && c.year==this.year;
    }
    
    
   
    
}
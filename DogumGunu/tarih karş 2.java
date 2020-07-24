  public int differenceBetweenTwoDates(Date birthday) throws ParseException {

        Period diff = null;
        Calendar birthdayCal = Calendar.getInstance();
        Calendar current = systemDate();
        birthdayCal.setTime( birthday );

        birthdayCal.set( Calendar.YEAR,2018 );
        birthdayCal.setTime( birthdayCal.getTime() );
        int diffDay = countDiffDay( birthdayCal,current );
        return diffDay;

    }

    public static int countDiffDay(Calendar c1,Calendar c2) {
        int returnInt = -1;
        if (c1.compareTo( c2 ) == 1 || c1.compareTo( c2 ) == 0) {
            while (!c2.after( c1 )) {
                c2.add( Calendar.DAY_OF_MONTH,1 );
                returnInt++;
            }

        } else {
            returnInt = -1;
        }


        return (returnInt);
    }
}
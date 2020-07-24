//tarihlerin farki
    public static int dateDifference(String birthday) throws ParseException {

        int tempDifference = 0;
        int difference = 0;
        Calendar past = getCalendar( "dd.MM.yyyy",birthday );


        //Calendar born = DateToCalendar( "birthday" );
        Calendar takvim = systemDate();
        Calendar earlier = Calendar.getInstance();
        Calendar later = Calendar.getInstance();

        if (past.compareTo( takvim ) < 0) {
            earlier.set( takvim.get( Calendar.YEAR ),takvim.get( Calendar.MONTH ),takvim.get( Calendar.DAY_OF_WEEK ) );
            later.set( past.get( Calendar.YEAR ),past.get( Calendar.MONTH ),past.get( Calendar.DAY_OF_WEEK ) );
        } else {
            earlier.set( past.get( Calendar.YEAR ),past.get( Calendar.MONTH ),past.get( Calendar.DAY_OF_WEEK ) );
            later.set( takvim.get( Calendar.YEAR ),takvim.get( Calendar.MONTH ),takvim.get( Calendar.DAY_OF_WEEK ) );
        }

        while (earlier.get( Calendar.YEAR ) != later.get( Calendar.YEAR )) {

            tempDifference = 365 * (later.get( Calendar.YEAR ) - earlier.get( Calendar.YEAR ));
            difference = tempDifference;
            earlier.add( Calendar.DAY_OF_WEEK,tempDifference );
        }

        if (earlier.get( Calendar.DAY_OF_WEEK ) != later.get( Calendar.DAY_OF_WEEK )) {
            tempDifference = later.get( Calendar.DAY_OF_WEEK ) - earlier.get( Calendar.DAY_OF_WEEK );
            difference = tempDifference;
            earlier.add( Calendar.DAY_OF_WEEK,tempDifference );
        }


        return difference;

    }






    //Stringten calendar cinsine cevirme

    public static Calendar getCalendar(String dateFormat,String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat( dateFormat );
        Date dt = sdf.parse( String.valueOf( date ) );
        Calendar calendar = systemDate();
        calendar.setTime( dt );
        return calendar;
    }




   //Sistem tarihi alma
    private static Calendar systemDate() {
        return Calendar.getInstance();
    }
/* //Date Calendar cinsine çevirme
    public static Calendar DateToCalendar(Date birthday) {
        Calendar cal = null;
        try {
            DateFormat formatter = new SimpleDateFormat( "dd.MM.yyyy" );
            birthday = (Date) formatter.parse( birthday.toString() );
            cal = Calendar.getInstance();
            cal.setTime( birthday );
        } catch (ParseException e) {
            System.out.println( "Exception :" + e );
        }
        return cal;
    }
*/
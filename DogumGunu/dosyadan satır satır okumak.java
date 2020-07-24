   public static void readALine(String fulPath) throws IOException {             //Dosyadan satir satir okumak

        String line;

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( new FileInputStream( new File( fulPath ) ) ) );

        while ((line = String.valueOf( bufferedReader.readLine() )) != null) {

            line = bufferedReader.readLine();
            System.out.println( line );
       }
    }
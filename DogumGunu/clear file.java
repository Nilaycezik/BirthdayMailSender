    public static void clearFile(String fulPath) {        //main.java.utils.FileUtils silme

            File f = new File( fulPath );
            if (f.exists()) {         //eger main.java.utils.FileUtils varsa
            f.delete();
            System.out.println( "main.java.utils.FileUtils silinmesi basarili" );

            } else {                   //eger main.java.utils.FileUtils yoksa
            System.out.println( "Dosya bulunamadigindan silinemedi" );
            }
            }
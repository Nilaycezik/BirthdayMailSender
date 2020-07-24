    private static long start;
    private static long end;
    private static boolean started;

 /*Kronometre durmus vaziyette mi?*/

    private static boolean isStopped() {
        return !started;
    }

    /*
      Kronometre baalamis vaziyette mi?
      @return
     */

    private static boolean isStarted() {
        return started;
    }

    /*
     Kronometreyi baslatir. E�er zaten ba�lam�� durumda ise RunTimeException hatas� atar.
     */
    public static void start() {
        if (isStopped()) {
            startTimer();
        } else {
            throw new RuntimeException( "Hata: Kronometre (TimerMain) zaten baslatilmis durumda!!!\n" );
        }
    }

    private static void startTimer() {
        start = System.nanoTime();
        started = true;
    }

    /**
     * Kronometreyi durdurur. Eger zaten baslamamis ise RunTimeException hatasi atar.
     */
    public static void stop() {
        if (isStarted()) {
            stopTimer();
        } else {
            throw new RuntimeException( "Hata: Kronometre (TimerMain) baslatilmadi!!!\n" );
        }
    }

    private static void stopTimer() {
        end = System.nanoTime();
        started = false;
    }

    /**
     * TimerMain.start() ile TimerMain.stop() arasinda gecen sureyi nanosaniye olarak dondurur.
     */
    public static long getElapsedTime() {
        if (isStopped()) {
            return end - start;
        } else {
            throw new RuntimeException( "Hata: Kronometre (TimerMain) durdurulmadi!!!\n" );
        }

    }

    /**
     * TimerMain.start() ile TimerMain.stop() arasinda gecen sureyi milisaniye cinsinden dondurur.
     */
    public static double getElapsedMilliseconds() {
        double seconds = (double) getElapsedTime() / 1000000.0;
        return seconds;
    }

    /**
     * TimerMain.start() ile TimerMain.stop() arasinda gecen sureyi saniye cinsinden dondurur.
     */
    public static double getElapsedSeconds() {
        double seconds = (double) getElapsedTime() / 1000000000.0;
        return seconds;
    }
package facade.main.java;

class Tuner {
    private Amplifier amplifier;

    Tuner(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    void on() {
        System.out.println("Tuner on");
    }

    void off() {
        System.out.println("Tuner off");
    }
}

class Amplifier {
    private Tuner tuner;
    private DvdPlayer dvdPlayer;
    private CdPlayer cdPlayer;

    Amplifier(Tuner tuner, DvdPlayer dvdPlayer, CdPlayer cdPlayer) {
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cdPlayer = cdPlayer;
    }

    void on() {
        System.out.println("Amplifier on");
    }

    void off() {
        System.out.println("Amplifier off");
    }

    void setSurroundSound() {
        System.out.println("Amplifier set to Surround Sound");
    }

    void setStereoSound() {
        System.out.println("Amplifier set to Stereo Sound");
    }

    void setVolume(int volume) {
        System.out.println("Amplifier volume set to " + volume);
    }

    void setCd(CdPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
    }

    void setDvd(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    void setTuner(Tuner tuner) {
        this.tuner = tuner;
    }
}

class DvdPlayer {
    private Amplifier amplifier;

    DvdPlayer(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    void on() {
        System.out.println("DVD Player on");
    }

    void off() {
        System.out.println("DVD Player off");
    }

    void play() {
        System.out.println("DVD Player playing");
    }

    void stop() {
        System.out.println("DVD Player stopped");
    }

    void eject() {
        System.out.println("DVD Player ejected");
    }
}

class CdPlayer {
    private Amplifier amplifier;

    CdPlayer(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    void on() {
        System.out.println("CD Player on");
    }

    void off() {
        System.out.println("CD Player off");
    }

    void play() {
        System.out.println("CD Player playing");
    }

    void stop() {
        System.out.println("CD Player stopped");
    }

    void eject() {
        System.out.println("CD Player ejected");
    }

    void setTwoChannelAudio() {
        System.out.println("CD Player set to Two Channel Audio");
    }

    void setSurroundAudio() {
        System.out.println("CD Player set to Surround Audio");
    }
}

class Projector {
    void on() {
        System.out.println("Projector on");
    }

    void off() {
        System.out.println("Projector off");
    }

    void tvMode() {
        System.out.println("Projector set to TV mode");
    }

    void wideScreenMode() {
        System.out.println("Projector set to Wide Screen mode");
    }
}

class Screen {
    void up() {
        System.out.println("Screen up");
    }

    void down() {
        System.out.println("Screen down");
    }
}

class PopcornPopper {
    void on() {
        System.out.println("Popcorn Popper on");
    }

    void off() {
        System.out.println("Popcorn Popper off");
    }
}

class TheaterLights {
    void on() {
        System.out.println("Theater lights on");
    }

    void off() {
        System.out.println("Theater lights off");
    }

    void dim() {
        System.out.println("Theater lights dim");
    }
}

class MovieTheaterFacade {
    private Tuner tuner;
    private Amplifier amplifier;
    private DvdPlayer dvdPlayer;
    private CdPlayer cdPlayer;
    private Projector projector;
    private Screen screen;
    private PopcornPopper popcornPopper;
    private TheaterLights theaterLights;

    MovieTheaterFacade() {
        amplifier = new Amplifier(null, null, null);

        tuner = new Tuner(amplifier);
        dvdPlayer = new DvdPlayer(amplifier);
        cdPlayer = new CdPlayer(amplifier);

        amplifier.setCd(cdPlayer);
        amplifier.setDvd(dvdPlayer);
        amplifier.setTuner(tuner);

        projector = new Projector();
        screen = new Screen();
        popcornPopper = new PopcornPopper();
        theaterLights = new TheaterLights();
    }

    void watchMovie() {
        popcornPopper.on();
        popcornPopper.off();

        theaterLights.dim();

        screen.down();

        projector.on();

        amplifier.on();

        dvdPlayer.on();
    }

    void endMovie() {
        popcornPopper.off();
        screen.up();
        projector.off();
        amplifier.off();
        dvdPlayer.off();
    }

}

class Main {
    public static void main(String[] args) {
        MovieTheaterFacade movieTheater = new MovieTheaterFacade();
        movieTheater.watchMovie();
        System.out.println("Enjoying the movie...");
        movieTheater.endMovie();
    }
}

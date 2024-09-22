import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// General Class
class Orang {
    protected String Nama;

    public Orang(String Nama) {
        this.Nama = Nama;
    }

    public String getDetails() {
        return "Nama: " + Nama;
    }
}

// Specialized Mahasiswa class
class Mahasiswa extends Orang {
    private int NIM;
    private String Prodi;
    private int Angkatan;

    public Mahasiswa(String Nama, String Prodi, int Angkatan, int NIM) {
        super(Nama);
        this.NIM = NIM;
        this.Prodi = Prodi;
        this.Angkatan = Angkatan;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Prodi: " + Prodi + ", Angkatan: " + Angkatan + ", NIM: " + NIM;
    }
}

// Specialized Dosen class
class Dosen extends Orang {
    private String KodeDosen;
    private List<Matkul> matkulList;

    public Dosen(String Nama, String KodeDosen) {
        super(Nama);
        this.KodeDosen = KodeDosen;
        this.matkulList = new ArrayList<>();
    }

    public void tambahMatkul(Matkul matkul) {
        matkulList.add(matkul);
    }

    public List<Matkul> getMatkulList() {
        return matkulList;
    }

    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder(super.getDetails() + ", Kode Dosen:" + KodeDosen + " \n  Mengajar:");
        for (Matkul matkul : matkulList) {
            details.append("- ").append(matkul.getNamaMatkul()).append("\n");
        }
        return details.toString();
    }
}

// Matkul class
class Matkul {
    private String NamaMatkul;
    private String KodeMatkul;
    private String Ruangan;

    public Matkul(String NamaMatkul, String KodeMatkul, String Ruangan) {
        this.NamaMatkul = NamaMatkul;
        this.KodeMatkul = KodeMatkul;
        this.Ruangan = Ruangan;
    }

    public String getNamaMatkul() {
        return NamaMatkul;
    }

    public String getDetails() {
        return "" + NamaMatkul +  " (" + KodeMatkul + ") \n Ruangan: " + Ruangan;
    }
}

// Jadwal class
class Jadwal {
    private String Hari;
    private List<Matkul> matkulList;

    public Jadwal(String Hari) {
        this.Hari = Hari;
        this.matkulList = new ArrayList<>();
    }

    public void tambahMatkul(Matkul matkul) {
        matkulList.add(matkul);
    }

    public String getScheduleDetails() {
        StringBuilder scheduleDetails = new StringBuilder("Hari: " + Hari + "\n");
        for (Matkul matkul : matkulList) {
            scheduleDetails.append("- ").append(matkul.getDetails()).append("\n");
        }
        return scheduleDetails.toString();
    }
}

// Program Akademik JTK
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create list of mahasiswa
        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        mahasiswaList.add(new Mahasiswa("Alana Tanisya Anwar", "D3 Teknik Informatika", 2023, 231511034));
        mahasiswaList.add(new Mahasiswa("Alya Gustiani Nur Afifah ", "D3 Teknik Informatika", 2023, 231511035));
        mahasiswaList.add(new Mahasiswa("Dhea Dria Spralia", "D3 Teknik Informatika", 2023, 231511040));
        mahasiswaList.add(new Mahasiswa("Dhira Ramadhini", "D3 Teknik Informatika", 2023, 231511041));
        mahasiswaList.add(new Mahasiswa("Erina Dwi Yanti", "D3 Teknik Informatika", 2023, 231511043));
        mahasiswaList.add(new Mahasiswa("Febi Shintawati", "D3 Teknik Informatika", 2023, 231511045));
        mahasiswaList.add(new Mahasiswa("Febytha Putri Nugraheni", "D3 Teknik Informatika", 2023, 231511046));
        mahasiswaList.add(new Mahasiswa("Firgianatyas Siti Eka Fadilah", "D3 Teknik Informatika", 2023, 231511047));
        mahasiswaList.add(new Mahasiswa("Indah Ratu Pramudita", "D3 Teknik Informatika", 2023, 231511050));
        mahasiswaList.add(new Mahasiswa("Nazla Kayla", "D3 Teknik Informatika", 2023, 231511057));
        mahasiswaList.add(new Mahasiswa("Yani Rahmawati", "D3 Teknik Informatika", 2023, 231511063));

        // Create list of Dosen
        List<Dosen> dosenList = new ArrayList<>();
        Dosen dosen1 = new Dosen("Yudhi Widhiyasana", "KO013N");
        Dosen dosen2 = new Dosen("Santi Sundari", "KO009N");
        Dosen dosen3 = new Dosen("Trisna Gelar A", "KO078N");
        Dosen dosen4 = new Dosen("Ade Hodijah", "KO060N");
        Dosen dosen5 = new Dosen("Muhammad Rizqi S", "KO074N");
        Dosen dosen6 = new Dosen("Bambang Wisnuadhi", "KO003N");
        Dosen dosen7 = new Dosen("Wendi Wirasta", "KO079N");
        Dosen dosen8 = new Dosen("Didik Suwito Pribadi", "KO005N");
        Dosen dosen9 = new Dosen("Ade Chandra Nugraha", "KO001N");
        Dosen dosen10 = new Dosen("Zulkifli Arsyad", "KO061N");
        Dosen dosen11 = new Dosen("Siti Dwi Setiarini", "KO075N");
        Dosen dosen12= new Dosen("Yadhi Aditya P", "KO052N");
        dosenList.add(dosen1);
        dosenList.add(dosen2);
        dosenList.add(dosen3);
        dosenList.add(dosen4);
        dosenList.add(dosen5);
        dosenList.add(dosen6);
        dosenList.add(dosen7);
        dosenList.add(dosen8);
        dosenList.add(dosen9);
        dosenList.add(dosen10);
        dosenList.add(dosen11);
        dosenList.add(dosen12);

        // Create list of Matkul and assign them to Dosen
        Matkul matkul1 = new Matkul("Komputer Grafik (T)", "21IF2015", "Kelas 105");
        Matkul matkul2 = new Matkul("Pengantar Rekayasa Perangkat Lunak (T)", "21IF2013", "Kelas 105");
        Matkul matkul3 = new Matkul("Komputer Grafik (P)", "21IF2015", "LAB MM");
        Matkul matkul4 = new Matkul("Basis Data (P)", "21IF2012", "LAB SDB");
        Matkul matkul5 = new Matkul("Aljabar Linear", "21IF2014", "kELAS 101");
        Matkul matkul6 = new Matkul("Proyek 3", "21IF2016", "LAB PJBL 2");
        Matkul matkul7 = new Matkul("Basis Data (T)", "21IF2012", "Kelas 105");
        Matkul matkul8 = new Matkul("Pemrograman Berorientasi Objek (T)", "21IF2011", "Kelas 105");
        Matkul matkul9 = new Matkul("Pemrograman Berorientasi Objek (P)", "21IF2011", "LAB PJBL 2");
        Matkul matkul10 = new Matkul("Matematika Diskrit II", "21IF2010", "Kelas 108");
        Matkul matkul11 = new Matkul("Pengantar Rekayasa Perangkat Lunak", "21IF2013", "LAB PJBL 2");


        dosen1.tambahMatkul(matkul1);
        dosen2.tambahMatkul(matkul2);
        dosen3.tambahMatkul(matkul3);
        dosen4.tambahMatkul(matkul4);
        dosen5.tambahMatkul(matkul5);
        dosen6.tambahMatkul(matkul6);
        dosen7.tambahMatkul(matkul6);
        dosen8.tambahMatkul(matkul6);
        dosen9.tambahMatkul(matkul7);
        dosen10.tambahMatkul(matkul8);
        dosen10.tambahMatkul(matkul9);
        dosen11.tambahMatkul(matkul10);
        dosen12.tambahMatkul(matkul11);

        // Create list of Jadwal and assign multiple matkul to each day
        List<Jadwal> jadwalList = new ArrayList<>();
        Jadwal jadwalSenin = new Jadwal("Senin");
        jadwalSenin.tambahMatkul(matkul1);
        jadwalSenin.tambahMatkul(matkul2);
        jadwalSenin.tambahMatkul(matkul3);
        jadwalList.add(jadwalSenin);

        Jadwal jadwalSelasa = new Jadwal("Selasa");
        jadwalSelasa.tambahMatkul(matkul4);
        jadwalSelasa.tambahMatkul(matkul5);
        jadwalList.add(jadwalSelasa);

        Jadwal jadwalRabu = new Jadwal("Rabu");
        jadwalRabu.tambahMatkul(matkul6);
        jadwalList.add(jadwalRabu);

        Jadwal jadwalKamis = new Jadwal("Kamis");
        jadwalKamis.tambahMatkul(matkul7);
        jadwalKamis.tambahMatkul(matkul8);
        jadwalKamis.tambahMatkul(matkul9);
        jadwalKamis.tambahMatkul(matkul10);
        jadwalList.add(jadwalKamis);

        Jadwal jadwalJumat = new Jadwal("Jumat");
        jadwalJumat.tambahMatkul(matkul11);
        jadwalList.add(jadwalJumat);

        // Menu options
        System.out.println("Pilih data yang ingin ditampilkan:");
        System.out.println("1. Data Mahasiswa");
        System.out.println("2. Data Dosen");
        System.out.println("3. Jadwal Kuliah");
        System.out.println("4. Tampilkan Semua Data");
        System.out.print("Masukkan pilihan (1-4): ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                // Display student data
                System.out.println("Data Mahasiswa:");
                for (Mahasiswa mahasiswa : mahasiswaList) {
                    System.out.println(mahasiswa.getDetails());
                }
                break;

            case 2:
                // Display lecturer data
                System.out.println("Data Dosen:");
                for (Dosen dosen : dosenList) {
                    System.out.println(dosen.getDetails());
                }
                break;

            case 3:
                // Display course schedule
                System.out.println("Jadwal Kuliah:");
                for (Jadwal jadwal : jadwalList) {
                    System.out.println(jadwal.getScheduleDetails());
                }
                break;

            case 4:
                // Display all data
                System.out.println("Data Mahasiswa:");
                for (Mahasiswa mahasiswa : mahasiswaList) {
                    System.out.println(mahasiswa.getDetails());
                }

                System.out.println("\nData Dosen:");
                for (Dosen dosen : dosenList) {
                    System.out.println(dosen.getDetails());
                }

                System.out.println("\nJadwal Kuliah:");
                for (Jadwal jadwal : jadwalList) {
                    System.out.println(jadwal.getScheduleDetails());
                }
                break;

            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                break;
        }

        scanner.close();
    }
}

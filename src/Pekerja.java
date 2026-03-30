import java.time.LocalDate;
public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(double gaji, int tahun, int bulan, int tanggal, int jumlahAnak, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super(nama, nik, jenisKelamin, menikah);
        this.gaji = gaji;
        this.tahunMasuk = LocalDate.of(tahun, bulan, tanggal);
        this.jumlahAnak = jumlahAnak;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public double getGaji() {
        return gaji;
    }

    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    }

    public int getJumlahAnak() {
        return jumlahAnak;
    }

    public double getBonus() {
        int tahunSekarang = LocalDate.now().getYear();
        int tahunMasukKerja = tahunMasuk.getYear();
        int lamaBekerja = tahunSekarang - tahunMasukKerja;
        
        if (lamaBekerja >= 0 && lamaBekerja < 5) {
            return gaji * 0.05;
        } else if (lamaBekerja >= 5 && lamaBekerja <= 10) {
            return gaji * 0.10;
        } else if (lamaBekerja > 10) {
            return gaji * 0.15;
        }
        return 0;
    }

    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (jumlahAnak * 20.0);
    }

    @Override
    public double getPendapatan() {
        return getTunjangan() + getBonus() + gaji;
    }

     @Override
    public String toString() {
        return  super.toString() + "\n" +
                "Tahun Masuk    : " + tahunMasuk.getDayOfMonth() + " " + tahunMasuk.getMonthValue() + " " + tahunMasuk.getYear() + "\n" +
                "Jumlah Anak    : " + jumlahAnak + "\n" +
                "Gaji           : " + gaji;  
    }
}

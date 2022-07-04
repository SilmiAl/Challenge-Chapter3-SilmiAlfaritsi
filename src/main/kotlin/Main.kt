import java.util.*

fun main(args: Array<String>) {


    var isContinueMenu = true

    loopI@ while (isContinueMenu) {
        Utility.tampilanAwal()
        Utility.tampilanMainMenu()
        print("\nMasukkan pilihan anda : ")
        val userKeyword = readLine()?.lowercase()?.trim()?.replace("\t", "")
            ?.replace("satu", "1")?.replace("one", "1")
            ?.replace("dua", "2")?.replace("two", "2")
            ?.replace("tiga", "3")?.replace("three", "3")
        println()
        when (userKeyword) {
            "1" -> Sistem().twoPlayer()
            "2" -> Sistem().vsBot()
            "3" -> break@loopI
            else -> println("Pilihan salah, pilihan menu hanya (1 - 3 / satu - tiga) :)")
        }
        isContinueMenu = Utility.lanjutAtauTidak("Mau balik ke menu?")
    }
    Utility.Udahan()

    fun twoPlayer(){
        print("Masukkan nama Player 1 : ")
        var namaPlayerSatu = readLine()!!.uppercase().trim().replace(" ","").replace("\t","")
        if (namaPlayerSatu.isBlank()){
            namaPlayerSatu = "Anonymous_1"
        }
        val playerSatu = Pemain(namaPlayerSatu)

        print("Masukkan nama Player 2 : ")
        var namaPlayerDua = readLine()!!.uppercase().trim().replace(" ","").replace("\t","")
        if (namaPlayerDua.isBlank()){
            namaPlayerDua = "Anonymous_2"
        }
        val playerDua = Pemain(namaPlayerDua)

        var isKeepPlaying = true
        while (isKeepPlaying){
            Utility.tampilanMenu()
            playerSatu.attack(playerDua)
            isKeepPlaying = Utility.lanjutAtauTidak("Apakah Anda mau bermain lagi ?")
        }
    }

    fun vsBot() {
        print("Masukkan nama Player : ")
        var namaPlayerSatu = readLine()!!.uppercase().trim().replace(" ", "").replace("\t", "")
        if (namaPlayerSatu.isBlank()) {
            namaPlayerSatu = "Pemain Utama"
        }
        val playerSatu = Pemain(namaPlayerSatu)

        val playerBot = Anon("Bot")
        playerBot.name = "Anonymous"

        var isKeepPlaying = true
        while (isKeepPlaying) {
            Utility.tampilanMenu()
            playerSatu.attack(playerBot)
            isKeepPlaying = Utility.lanjutAtauTidak("Apakah Anda mau bermain lagi ?")
        }
    }
}
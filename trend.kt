// 0L: Empty 1L: Inactive
val game = mutableMapOf(
    "csgo" to 1L,
    "dead" to 931705320202453014,
    "destiny" to 1L,
    "dota" to 825921330531532842,
    "elden" to 673628715489558574,
    "escape" to 1003477997728313405,
    "fifa" to 912838349667074059,
    "fortnite" to 859502153101344768,
    "gta" to 799917070010548244,
    "hearth" to 608143654221250600,
    "league" to 908866947473604628,
    "lost" to 894059038592073728,
    "minecraft" to 406196759510122496,
    "mw2" to 697494341664636959,
    "pubg" to 799692463274065972,
    "rainbow" to 406196759510122496,
    "rocket" to 1L,
    "rust" to 815782688920829992,
    "teamfight" to 929774829207449632,
    "valorant" to 908866947473604628,
    "tanks" to 912838349667074059,
    "warcraft" to 912838349667074059,
    "warzone" to 965030800049446982
)
val alias = mapOf(
    "mw" to "mw2",
    "cod" to "mw2",
    "dbd" to "dead",
    "dest" to "destiny",
    "tarkov" to "escape",
    "fn" to "fortnite",
    "grand" to "gta",
    "hearthstone" to "hearth",
    "lol" to "league",
    "la" to "lost",
    "mc" to "minecraft",
    "rl" to "rocket",
    "siege" to "rainbow",
    "tactics" to "teamfight",
    "val" to "valorant",
    "wot" to "tanks",
    "wow" to "warcraft"
)
fun main() {
    var str = readln()
    while (str.isNotEmpty()) {
        /*str.split(' ').map { it.lowercase() }.forEach {
            if (game.contains(it))
                game.remove(it)
            else if (alias.contains(it))
                game.remove(alias[it])
            else
                System.err.println("Unrecognized key: $it")
        }*/
        str.split(' ').map{it.lowercase()}.mapNotNull {
            if (game.contains(it))
                it
            else if (alias.contains(it))
                alias[it]
            else {
                System.err.println("Unrecognized key: $it")
                null
            }
        }.forEach{
            game.remove(it)
        }
        for ((k, v) in game) {
            if (v != 0L && v != 1L) print("<@$v>: ")
            else if (v == 1L) print("__Inactive__: ")
            else print("__Empty__: ")
            println("*$k*")
        }
        str = readln()
    }
}

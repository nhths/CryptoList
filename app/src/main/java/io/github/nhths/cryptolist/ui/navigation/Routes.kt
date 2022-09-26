package io.github.nhths.cryptolist.ui.navigation

enum class MainRoutes(val key: CharSequence) : CharSequence by key {
    CRYPTO_LIST("CRYPTO_LIST"){
        val CRYPTO_ID = "CRYPTO_ID" //argument keys
    },
    CRYPTO_DETAILS("CRYPTO_DETAILS");
}
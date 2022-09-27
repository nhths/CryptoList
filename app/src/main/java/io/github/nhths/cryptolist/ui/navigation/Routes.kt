package io.github.nhths.cryptolist.ui.navigation

enum class MainRoutes(val key: CharSequence) : CharSequence by key {
    CRYPTO_LIST("CRYPTO_LIST"),
    CRYPTO_DETAILS("CRYPTO_DETAILS"),
    CRYPTO_DETAILS_ARG(CRYPTO_DETAILS_ARG)
}
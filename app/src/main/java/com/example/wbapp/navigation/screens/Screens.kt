package com.example.wbapp.navigation.screens

sealed class Screens(
    val screen: String
) {
    data object Communities: Screens("communities")
    data object Events: Screens("events")
    data object Other: Screens("other")
    data object Personal: Screens("personal")
    data object MyEvents: Screens("my_events")
}
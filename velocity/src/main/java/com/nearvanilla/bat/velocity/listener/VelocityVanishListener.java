package com.nearvanilla.bat.velocity.listener;

import com.google.inject.Inject;
import com.nearvanilla.bat.velocity.tab.TablistService;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.proxy.ProxyServer;
import ir.syrent.velocityvanish.velocity.event.VelocityUnVanishEvent;
import ir.syrent.velocityvanish.velocity.event.VelocityVanishEvent;
import org.checkerframework.checker.nullness.qual.NonNull;

public class VelocityVanishListener {

    private final @NonNull ProxyServer server;
    private final @NonNull TablistService tablistService;

    @Inject
    public VelocityVanishListener(final @NonNull ProxyServer server,
                                  final @NonNull TablistService tablistService) {
        this.server = server;
        this.tablistService = tablistService;


    }

    @Subscribe
    public void onVanish(final @NonNull VelocityVanishEvent event) {
        System.out.println("triggered vanish");
        if (event.getPlayer().isEmpty()) return;

        System.out.println("Leaving in vanish");
        this.tablistService.handlePlayerLeave(event.getPlayer().get());
    }

    @Subscribe
    public void onUnVanish(final @NonNull VelocityUnVanishEvent event) {
        System.out.println("triggered unvanish");
        if (event.getPlayer().isEmpty()) return;

        System.out.println("Joining in vanish");
        this.tablistService.handleServerConnection(event.getPlayer().get());
    }
}

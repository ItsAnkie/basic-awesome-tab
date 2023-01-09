package com.nearvanilla.bat.velocity.tab.group;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.UUID;

/**
 * {@code GroupProvider} defines methods to retrieve a user's inherited and primary groups.
 */
public interface GroupProvider {

    /**
     * Returns a {@link Collection} containing the IDs of all groups a player is a member of.
     *
     * @param uuid the uuid of a player
     * @return a {@link Collection}, will be empty if there is no group data for the provided {@link UUID}
     */
    @NonNull Collection<String> groups(final @NonNull UUID uuid);

    /**
     * Returns the primary group of a player.
     *
     * @param uuid the uuid of a player
     * @return the primary group name
     */
    @Nullable String primaryGroup(final @NonNull UUID uuid);

    /**
     * Returns the weight of the primary group of a player.
     *
     * @param uuid the uuid of a player
     * @return the primary group weight
     */
    int primaryGroupWeight(final @NonNull UUID uuid);

}

package dev.simplix.cirrus.bungeecord.converters;

import dev.simplix.cirrus.common.business.InventoryMenuItemWrapper;
import dev.simplix.cirrus.common.business.MenuItemWrapper;
import dev.simplix.cirrus.common.converter.Converter;
import dev.simplix.cirrus.common.converter.Converters;
import dev.simplix.cirrus.common.item.MenuItem;
import dev.simplix.protocolize.api.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ItemModelConverter implements Converter<MenuItem, InventoryMenuItemWrapper> {

    @Override
    public InventoryMenuItemWrapper convert(@NotNull MenuItem model) {
        ItemStack itemStack = new ItemStack(model.itemType(), model.amount(), model.durability());
        itemStack.nbtData(model.nbt());
        itemStack.displayName(model.displayName());
        itemStack.lore(model.lore(), true);

        return InventoryMenuItemWrapper.builder()
                .handle(Converters.convert(itemStack, MenuItemWrapper.class))
                .actionArguments(model.actionArguments())
                .actionHandler(model.actionHandler())
                .build();
    }

}

/*
 * Copyright (c) 2021 TeamMoeg
 *
 * This file is part of Steam Powered.
 *
 * Steam Powered is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * Steam Powered is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Steam Powered. If not, see <https://www.gnu.org/licenses/>.
 */

package com.teammoeg.steampowered.content.engine;

import java.util.List;

import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.teammoeg.steampowered.SPConfig;
import com.teammoeg.steampowered.client.ClientUtils;
import com.teammoeg.steampowered.registrate.SPBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.BlockGetter;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BronzeSteamEngineBlock extends SteamEngineBlock implements IBE<BronzeSteamEngineTileEntity> {
    public BronzeSteamEngineBlock(Properties builder) {
        super(builder);
    }

    @Override
    public BlockEntityType<? extends BronzeSteamEngineTileEntity> getBlockEntityType() {
        return SPBlockEntities.BRONZE_STEAM_ENGINE.get();
    }

    @Override
    public Class<BronzeSteamEngineTileEntity> getBlockEntityClass() {
        return BronzeSteamEngineTileEntity.class;
    }

    @Override
	public void appendHoverText(ItemStack i, BlockGetter w, List<Component> t,
			TooltipFlag f) {
    	if(Screen.hasShiftDown()) {
    		t.add(new TranslatableComponent("tooltip.steampowered.engine.brief").withStyle(ChatFormatting.GOLD));
    		if(ClientUtils.hasGoggles()) 
    		t.add(new TranslatableComponent("tooltip.steampowered.engine.steamconsume",SPConfig.COMMON.bronzeFlywheelSteamConsumptionPerTick.get()).withStyle(ChatFormatting.GOLD));
    	}else {
    		t.add(TooltipHelper.holdShift(TooltipHelper.Palette.GRAY,false));
    	}
		super.appendHoverText(i,w,t,f);
	}
}

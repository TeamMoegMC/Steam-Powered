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

package com.teammoeg.steampowered.client.instance;

import com.jozufozu.flywheel.api.MaterialManager;
import com.teammoeg.steampowered.oldcreatestuff.OldFlywheelBlockEntity;


public class BronzeFlywheelInstance extends AbstractSPFlywheelInstance {
    public BronzeFlywheelInstance(MaterialManager modelManager, OldFlywheelBlockEntity tile) {
        super(modelManager, tile);
    }
}

/*----------------------------------------------------------------------------------------------------------------
 * CupCarbon: OSM based Wireless Sensor Network design and simulation tool
 * www.cupcarbon.com
 * ----------------------------------------------------------------------------------------------------------------
 * Copyright (C) 2013 Ahcene Bounceur
 * ----------------------------------------------------------------------------------------------------------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *----------------------------------------------------------------------------------------------------------------*/

package synchronization;

import java.util.Collections;
import java.util.Vector;

import simulation.Event;

public class Scheduler {

	public Vector<Event> listEvents;
	SchedulerComparator comparator = null;

	public Scheduler() {
		comparator = new SchedulerComparator();
		listEvents = new Vector<Event>();
	}

	public Event getNextEvent() {
		if (listEvents.size() <= 0)
			return null;

		return listEvents.get(0);
	}

	public void addEvent(Event event) {
		listEvents.add(event);
		sort();
	}

	public void removeEvent(Event event) {
		listEvents.remove(event);
	}

	// a optimiser ...
	public void sort() {
		Collections.sort(listEvents, comparator);
	}
}

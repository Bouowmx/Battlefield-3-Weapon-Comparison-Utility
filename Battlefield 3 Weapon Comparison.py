#!/usr/bin/python
from time import clock #for benchmarking purposes
clock()
#Battlefield 3 Weapon Comparison by Sean Yip
print "Content-type: text/html\n"

#fuck that shit; shotguns just have to be that different

import cgi #Python suggests not to use "from cgi import *"
import cgitb
cgitb.enable()
from collections import OrderedDict #ordered dictionaries for the convenience; yeah, yeah, I know that order doesn't matter in a dictionary; I'm a bit OCD like that
from math import ceil

data = cgi.FieldStorage()

def apply_weapon_attachments(weapon, primary_attachment, secondary_attachment):
    weapon_stat = list(weapon_stats[weapon])
    if ((primary_attachment == "Bipod") and (weapon_attachments[weapon][weapon_attachments_key["Bipod"]] != None)):
        weapon_stat[weapon_stats_key["Recoil Up"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][0]
        if (weapon_attachments[weapon][weapon_attachments_key["Bipod"]][1] != None):
            weapon_stat[weapon_stats_key["Recoil Left"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][1]
            weapon_stat[weapon_stats_key["Recoil Right"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][1]
        if (weapon_attachments[weapon][weapon_attachments_key["Bipod"]][2] != None):
            weapon_stat[weapon_stats_key["ADS Stationary Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][2]
            weapon_stat[weapon_stats_key["ADS Stationary Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][2]
            weapon_stat[weapon_stats_key["ADS Stationary Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][2]
            weapon_stat[weapon_stats_key["ADS Moving Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][2]
            weapon_stat[weapon_stats_key["ADS Moving Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][2]
            weapon_stat[weapon_stats_key["ADS Moving Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][2]
        if (weapon_attachments[weapon][weapon_attachments_key["Bipod"]][3] != None):
            weapon_stat[weapon_stats_key["HIP Stationary Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][3]
            weapon_stat[weapon_stats_key["HIP Stationary Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][3]
            weapon_stat[weapon_stats_key["HIP Stationary Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][3]
            weapon_stat[weapon_stats_key["HIP Moving Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][3]
            weapon_stat[weapon_stats_key["HIP Moving Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][3]
            weapon_stat[weapon_stats_key["HIP Moving Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Bipod"]][3]
    if ((primary_attachment == "Foregrip") and (weapon_attachments[weapon][weapon_attachments_key["Foregrip"]] != None)):
        if (weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][0] != None):
            weapon_stat[weapon_stats_key["Recoil Up"]] *= weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][0]
        weapon_stat[weapon_stats_key["Recoil Left"]] *= weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][1]
        weapon_stat[weapon_stats_key["Recoil Right"]] *= weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][1]
        weapon_stat[weapon_stats_key["ADS Stationary Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][2]
        weapon_stat[weapon_stats_key["ADS Stationary Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][2]
        weapon_stat[weapon_stats_key["ADS Stationary Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][2]
        weapon_stat[weapon_stats_key["ADS Moving Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][2]
        weapon_stat[weapon_stats_key["ADS Moving Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][2]
        weapon_stat[weapon_stats_key["ADS Moving Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][2]
    if ((primary_attachment == "Laser Sight (Primary)") and (weapon_attachments[weapon][weapon_attachments_key["Laser Sight (Primary)"]] != None)):
        weapon_stat[weapon_stats_key["HIP Stationary Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight (Primary)"]]
        weapon_stat[weapon_stats_key["HIP Stationary Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight (Primary)"]]
        weapon_stat[weapon_stats_key["HIP Stationary Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight (Primary)"]]
        weapon_stat[weapon_stats_key["HIP Moving Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight (Primary)"]]
        weapon_stat[weapon_stats_key["HIP Moving Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight (Primary)"]]
        weapon_stat[weapon_stats_key["HIP Moving Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight (Primary)"]]
    if ((secondary_attachment == "Flash Suppressor") and (weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]] != None)):
        weapon_stat[weapon_stats_key["Recoil Up"]] *= weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]][0]
        if (weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]][1] != None):
            weapon_stat[weapon_stats_key["HIP Stationary Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]][1]
            weapon_stat[weapon_stats_key["HIP Stationary Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]][1]
            weapon_stat[weapon_stats_key["HIP Stationary Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]][1]
            weapon_stat[weapon_stats_key["HIP Moving Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]][1]
            weapon_stat[weapon_stats_key["HIP Moving Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]][1]
            weapon_stat[weapon_stats_key["HIP Moving Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]][1]
    if ((secondary_attachment == "Heavy Barrel") and (weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]] != None)):
        if (weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][0] != None):
            weapon_stat[weapon_stats_key["Damage Drop-off End"]] = weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][0]
        if (weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][1] != None):
            weapon_stat[weapon_stats_key["Muzzle Velocity"]] = weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][1]
        weapon_stat[weapon_stats_key["Recoil Up"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][2]
        weapon_stat[weapon_stats_key["ADS Stationary Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][3]
        weapon_stat[weapon_stats_key["ADS Stationary Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][3]
        weapon_stat[weapon_stats_key["ADS Stationary Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][3]
        weapon_stat[weapon_stats_key["ADS Moving Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][3]
        weapon_stat[weapon_stats_key["ADS Moving Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][3]
        weapon_stat[weapon_stats_key["ADS Moving Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][3]
        weapon_stat[weapon_stats_key["HIP Stationary Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][4]
        weapon_stat[weapon_stats_key["HIP Stationary Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][4]
        weapon_stat[weapon_stats_key["HIP Stationary Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][4]
        weapon_stat[weapon_stats_key["HIP Moving Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][4]
        weapon_stat[weapon_stats_key["HIP Moving Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][4]
        weapon_stat[weapon_stats_key["HIP Moving Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][4]
    if ((secondary_attachment == "Laser Sight") and (weapon_attachments[weapon][weapon_attachments_key["Laser Sight"]] != None)):
        weapon_stat[weapon_stats_key["HIP Stationary Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight"]]
        weapon_stat[weapon_stats_key["HIP Stationary Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight"]]
        weapon_stat[weapon_stats_key["HIP Stationary Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight"]]
        weapon_stat[weapon_stats_key["HIP Moving Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight"]]
        weapon_stat[weapon_stats_key["HIP Moving Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight"]]
        weapon_stat[weapon_stats_key["HIP Moving Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Laser Sight"]]
    if ((secondary_attachment == "Suppressor") and (weapon_attachments[weapon][weapon_attachments_key["Suppressor"]] != None)):
        weapon_stat[weapon_stats_key["Damage Drop-off Start"]] = weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][0]
        weapon_stat[weapon_stats_key["Damage Drop-off End"]] = weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][1]
        if (weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][2] != None):
            weapon_stat[weapon_stats_key["Muzzle Velocity"]] = weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][2]
        weapon_stat[weapon_stats_key["Recoil Up"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][3]
        if (weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][4] != None):
            weapon_stat[weapon_stats_key["ADS Stationary Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][4]
            weapon_stat[weapon_stats_key["ADS Stationary Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][4]
            weapon_stat[weapon_stats_key["ADS Stationary Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][4]
            weapon_stat[weapon_stats_key["ADS Moving Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][4]
            weapon_stat[weapon_stats_key["ADS Moving Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][4]
            weapon_stat[weapon_stats_key["ADS Moving Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][4]
        if (weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][5] != None):
            weapon_stat[weapon_stats_key["HIP Stationary Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][5]
            weapon_stat[weapon_stats_key["HIP Stationary Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][5]
            weapon_stat[weapon_stats_key["HIP Stationary Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][5]
            weapon_stat[weapon_stats_key["HIP Moving Standing Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][5]
            weapon_stat[weapon_stats_key["HIP Moving Crouching Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][5]
            weapon_stat[weapon_stats_key["HIP Moving Prone Spread"]] *= weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][5]

    return tuple(weapon_stat)

def hits_to_kill_distance(max_damage, min_damage, damage_do_start, damage_do_end, muzzle_velocity, hits, sniper=False):
    max_damage = float(max_damage)
    min_damage = float(min_damage)
    damage_do_start = float(damage_do_start)
    damage_do_end = float(damage_do_end)
    muzzle_velocity = float(muzzle_velocity)
    if (type(hits) != type(1)): #if hits is not an integer
        return 0
    if ((hits < ceil((100 / max_damage))) or (hits > ceil((100 / min_damage)))):
        return 0
    if (hits == ceil((100 / max_damage))):
        return int(damage_do_start)
    if (hits == ceil((100 / min_damage))):
        if sniper:
            return muzzle_velocity * 5
        else:
            if (str(muzzle_velocity * 1.5)[-1] == "0"):
                return int(muzzle_velocity * 1.5)
            else:
                return muzzle_velocity * 1.5
    return ((100 / hits) - max_damage) / ((min_damage - max_damage) / (damage_do_end - damage_do_start)) + damage_do_start

def damage(max_damage, min_damage, damage_do_start, damage_do_end, distance):
    max_damage = float(max_damage) #just float everything.
    min_damage = float(min_damage)
    damage_do_start = float(damage_do_start)
    damage_do_end = float(damage_do_end)
    distance = float(distance)
    if (distance <= damage_do_start):
        return max_damage
    if (distance >= damage_do_end):
        return min_damage
    return max_damage + (((min_damage - max_damage) / (damage_do_end - damage_do_start)) * (distance - damage_do_start))

def ttk(max_damage, min_damage, damage_do_start, damage_do_end, rof, muzzle_velocity, distance, health=100):
    rof = float(rof)
    muzzle_velocity = float(muzzle_velocity)
    health = float(health)
    distance = float(distance)
    return 1000 * (((60 / rof) * ((ceil(health / damage(max_damage, min_damage, damage_do_start, damage_do_end, distance))) - 1)) + (distance / muzzle_velocity)) #returns in number of milliseconds

def weapon_attachment_effects_table(weapon, attachment):
    if (attachment == "None"):
        return ""
    if (weapon_attachments[weapon][weapon_attachments_key[attachment]] == None):
        return ""
    table = weapon + " " + attachment + '\n\t\t<table border="1">\n'
    table = table.replace(" (Primary)", "")
    if ((attachment == "Bipod") and (weapon_attachments[weapon][weapon_attachments_key["Bipod"]] != None)):
        table += "\t\t\t<tr><th>Recoil Up</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Bipod"]][0]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>Horizontal Recoil</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Bipod"]][1]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>ADS Spread</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Bipod"]][2]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>HIP Spread</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Bipod"]][3]) + "</td></tr>\n"
    if ((attachment == "Flash Suppressor") and (weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]] != None)):
        table += "\t\t\t<tr><th>Recoil Up</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]][0]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>HIP Spread</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Flash Suppressor"]][1]) + "</td></tr>\n"
    if ((attachment == "Foregrip") and (weapon_attachments[weapon][weapon_attachments_key["Foregrip"]] != None)):
        table += "\t\t\t<tr><th>Recoil Up</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][0]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>Horizontal Recoil</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][1]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>ADS Spread</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Foregrip"]][2]) + "</td></tr>\n"
    if ((attachment == "Heavy Barrel") and (weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]] != None)):
        if (weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][0] != None):
            table += "\t\t\t<tr><th>Damage Drop-off End</th><td>" + str(weapon_stats[weapon][weapon_stats_key["Damage Drop-off End"]] - weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][0]) + "</td></tr>\n"
        else:
            table += "\t\t\t<tr><th>Damage Drop-off End</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][0]) + "</td></tr>\n"
        if (weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][1] != None):
            table += "\t\t\t<tr><th>Muzzle Velocity</th><td>" + str(weapon_stats[weapon][weapon_stats_key["Muzzle Velocity"]] - weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][1]) + "</td></tr>\n"
        else:
            table += "\t\t\t<tr><th>Muzzle Velocity</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][1]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>Recoil Up</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][2]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>ADS Spread</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][3]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>HIP Spread</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Heavy Barrel"]][4]) + "</td></tr>\n"
    if ((attachment == "Laser Sight (Primary)") and (weapon_attachments[weapon][weapon_attachments_key["Laser Sight (Priamry)"]] != None)):
        table += "\t\t\t<tr><th>HIP Spread</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Laser Sight (Priamry)"]]) + "</td></tr>\n"
    if ((attachment == "Laser Sight") and (weapon_attachments[weapon][weapon_attachments_key["Laser Sight"]] != None)):
        table += "\t\t\t<tr><th>HIP Spread</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Laser Sight"]]) + "</td></tr>\n"
    if ((attachment == "Suppressor") and (weapon_attachments[weapon][weapon_attachments_key["Suppressor"]] != None)):
        if (weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][0] != None):
            table += "\t\t\t<tr><th>Damage Drop-off Start</th><td>" + str(weapon_stats[weapon][weapon_stats_key["Damage Drop-off Start"]] - weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][0]) + "</td></tr>\n"
        else:
            table += "\t\t\t<tr><th>Damage Drop-off Start</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][0]) + "</td></tr>\n"
        if (weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][1] != None):
            table += "\t\t\t<tr><th>Damage Drop-off End</th><td>" + str(weapon_stats[weapon][weapon_stats_key["Damage Drop-off End"]] - weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][2]) + "</td></tr>\n"
        else:
            table += "\t\t\t<tr><th>Damage Drop-off End</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][1]) + "</td></tr>\n"
        if (weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][2] != None):
            table += "\t\t\t<tr><th>Muzzle Velocity</th><td>" + str(weapon_stats[weapon][weapon_stats_key["Muzzle Velocity"]] - weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][2]) + "</td></tr>\n"
        else:
            table += "\t\t\t<tr><th>Muzzle Velocity</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][2]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>Recoil Up</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][3]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>ADS Spread</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][4]) + "</td></tr>\n"
        table += "\t\t\t<tr><th>HIP Spread</th><td>" + str(weapon_attachments[weapon][weapon_attachments_key["Suppressor"]][5]) + "</td></tr>\n"
    return table + "\t\t</table>\n"

#all weapon data directly in the Python file to avoid having to read and process external files
weapon_stats = OrderedDict([(".44 Magnum", (60, 30, 12, 50, 160, 460, 15, 2, 0.2, 0.2, 1, 4, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 1, 1, 1, 2, 1, 1, 0.3, 15, False)),
                            ("93R", (20, 12.5, 8, 40, 900, 380, 7, 0.5, 0.2, 0.2, 1.5, 30, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 1.5, 1, 1, 2, 1.5, 1.5, 0.2, 15, False)),
                            ("A-91", (25, 14.3, 8, 50, 800, 420, 7, 0.2, 0.5, 0.5, 3, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 1.5, 1, 1, 2, 1.5, 1.5, 0.1, 15, False)),
                            ("ACW-R", (20, 16.7, 8, 50, 850, 500, 7, 0.2, 0.1, 0.3, 2.5, 18, 0.3, 0.3, 0.3, 0.9, 0.9, 1, 2.25, 2, 1.5, 2.75, 2.5, 1.75, 0.1, 15, False)),
                            ("AEK-971", (25, 18.4, 8, 50, 900, 580, 7, 0.2, 0.5, 0.3, 3, 18, 0.3, 0.3, 0.3, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, False)),
                            ("AK-74M", (25, 18.4, 8, 50, 650, 600, 7, 0.28, 0.2, 0.3, 1.5, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, False)),
                            ("AKS-74U", (25, 14.3, 8, 50, 650, 440, 7, 0.28, 0.2, 0.3, 1.5, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, False)),
                            ("AN-94", (25, 18.4, 8, 50, 600, 600, 7, 0.3, 0.2, 0.3, 1.5, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, False)),
                            ("AS Val", (20, 18.4, 6, 40, 900, 333, 7, 0.4, 0.2, 0.3, 0.5, 18, 0, 0, 0, 1.5, 1.5, 1.5, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, False)),
                            ("AUG A3", (25, 18.4, 8, 50, 700, 670, 7, 0.2, 0.3, 0.4, 2.6, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, False)),
                            ("F2000", (25, 18.4, 8, 50, 850, 600, 7, 0.26, 0.5, 0.4, 3, 18, 0.4, 0.4, 0.4, 0.7, 0.7, 0.7, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, False)),
                            ("FAMAS", (25, 18.4, 8, 50, 1000, 630, 7, 0.35, 0.35, 0.55, 2.6, 18, 0.4, 0.4, 0.4, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, False)),
                            ("G17C", (25, 13.75, 12, 50, 400, 375, 7, 0.7, 0.1, 0.1, 1, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.5, 1.5, 0.2, 15, False)),
                            ("G18", (20, 12.5, 8, 40, 900, 375, 7, 0.7, 0.4, 0.4, 2.4, 30, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 1.5, 1, 1, 2, 1.5, 1.5, 0.5, 15, False)),
                            ("G36C", (25, 14.3, 8, 50, 750, 500, 7, 0.28, 0.3, 0.3, 1.8, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, False)),
                            ("G3A3", (34, 22, 8, 60, 550, 500, 10, 0.45, 0.2, 0.2, 1.4, 15, 0.1, 0.1, 0.1, 1.5, 1.5, 1.5, 3.5, 3, 2.5, 4, 3.5, 3, 0.12, 15, False)),
                            ("G53", (25, 14.3, 8, 50, 750, 450, 7, 0.24, 0.2, 0.35, 2.5, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, False)),
                            ("JNG-90", (80, 59, 15, 100, 46.2, 560, 35, 2, 0, 0, 1.5, 15, 0, 0, 0, 1.5, 1, 1, 5, 4, 3, 6, 5, 4, 1.2, 15, True)), #strangely, the JNG-90, a bolt action sniper, has a 1.5x FSM
                            ("KH2002", (25, 18.4, 8, 50, 800, 650, 7, 0.2, 0.4, 0.4, 1.5, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, False)),
                            ("L85A2", (25, 18.4, 8, 50, 650, 600, 7, 0.2, 0.28, 0.28, 2.5, 18, 0.2, 0.2, 0.2, 0.7, 0.7, 0.7, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, False)),
                            ("L86A2", (25, 18.4, 8, 50, 750, 640, 7, 0.32, 0.15, 0.25, 2, 13, 0.4, 0.4, 0.2, 1.5, 1, 1, 3, 3, 2.5, 4, 4, 3.5, 0.1, 15, False)),
                            ("L96", (80, 59, 15, 100, 43.5, 540, 35, 2, 0, 0, 1, 15, 0, 0, 0, 1.5, 1, 1, 5, 4, 3, 6, 5, 4, 1.2, 15, True)),
                            ("LSAT", (25, 18.4, 8, 50, 650, 620, 7, 0.4, 0.35, 0.35, 2.1, 15, 0.5, 0.4, 0.2, 1.5, 1.25, 1.25, 4, 3.25, 2.5, 5, 4.5, 3.5, 0.1, 15, False)),
                            ("M16A3", (25, 18.4, 8, 50, 800, 650, 7, 0.26, 0.1, 0.4, 2.5, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, False)),
                            ("M16A4", (25, 18.4, 8, 50, 800, 650, 7, 0.26, 0.075, 0.3, 2.5, 18, 0.1, 0.1, 0.1, 0.5, 0.5, 0.5, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, False)),
                            ("M1911", (34, 14.3, 12, 50, 333, 300, 7, 0.7, 0.1, 0.1, 1, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.5, 1.5, 0.2, 15, False)),
                            ("M240B", (34, 22, 8, 60, 650, 610, 10, 0.7, 0.5, 0.5, 1.7, 12, 0.5, 0.4, 0.2, 1.5, 1.5, 1.5, 5, 4, 3, 6, 5, 4, 0.12, 15, False)),
                            ("M249", (25, 18.4, 8, 50, 800, 620, 7, 0.4, 0.4, 0.4, 2.2, 12, 0.5, 0.4, 0.2, 1.5, 1, 1, 5, 4, 3, 6, 5, 4, 0.1, 15, False)),
                            ("M27 IAR", (25, 18.4, 8, 50, 750, 650, 7, 0.35, 0.1, 0.3, 2.2, 13, 0.4, 0.4, 0.2, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.1, 15, False)),
                            ("M39 EMR", (50, 37.5, 15, 75, 300, 570, 20, 1.2, 0.2, 0.2, 1, 6, 0.0167, 0.0167, 0.0167, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.8, 15, True)),
                            ("M4", (25, 14.3, 8, 50, 800, 580, 7, 0.26, 0.075, 0.2, 2.8, 18, 0.2, 0.2, 0.2, 0.4, 0.4, 0.4, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, False)),
                            ("M40A5", (80, 59.5, 15, 100, 54.5, 490, 35, 2, 0, 0, 1, 15, 0, 0, 0, 1, 1, 1, 4, 3.5, 3, 5, 4.5, 4, 1.2, 15, True)),
                            ("M416", (25, 18.4, 8, 50, 750, 600, 7, 0.26, 0.1, 0.3, 2, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, False)),
                            ("M417", (50, 37.5, 15, 75, 295, 450, 20, 1.15, -0.05, 0.25, 1, 10, 0.05, 0.05, 0.05, 1.5, 1, 1, 3, 3, 2.5, 4.5, 4, 3.5, 0.55, 15, True)),
                            ("M4A1", (25, 14.3, 8, 50, 800, 580, 7, 0.26, 0.1, 0.4, 2.8, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, False)),
                            ("M5K", (25, 13.75, 12, 50, 900, 380, 7, 0.25, 0.48, 0.48, 1.55, 30, 0.6, 0.6, 0.6, 0.6, 0.6, 0.6, 1.2, 1.2, 1.2, 1.7, 1.5, 1.5, 0.1, 1.5, False)),
                            ("M60E4", (34, 22, 8, 60, 580, 560, 10, 0.6, 0.2, 0.2, 1.5, 12, 0.5, 0.4, 0.2, 1.5, 1.5, 1.5, 5, 4, 3, 6, 5, 4, 0.12, 15, False)),
                            ("M9", (25, 13.75, 12, 50, 400, 380, 7, 0.7, 0.1, 0.1, 1, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.5, 1.5, 0.2, 15, False)),
                            ("M98B", (95, 59, 15, 150, 46.2, 650, 35, 2, 0, 0, 1, 15, 0, 0, 0, 1.5, 1, 1, 5, 4, 3, 6, 5, 4, 1.2, 15, True)),
                            ("MG36", (25, 18.4, 8, 50, 750, 550, 7, 0.4, 0.1, 0.3, 1.8, 13, 0.4, 0.4, 0.4, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.1, 15, False)),
                            ("MK11 MOD 0", (50, 37.5, 15, 75, 260, 550, 20, 1.5, -0.1, 0.3, 1, 6, 0.0167, 0.0167, 0.0167, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.8, 15, True)),
                            ("MP412 REX", (50, 28, 15, 37, 255, 370, 15, 1.2, 0.2, 0.2, 1, 10, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 1.25, 1, 1, 1.75, 1.5, 1.5, 0.3, 15, False)),
                            ("MP443", (25, 13.75, 12, 50, 400, 320, 7, 0.7, 0.1, 0.1, 1, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.5, 1.5, 0.2, 15, False)),
                            ("MP7", (20, 11.2, 12, 46, 950, 390, 7, 0.12, 0.45, 0.45, 2.2, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.25, 1.25, 0.06, 15, False)),
                            ("MTAR-21", (25, 14.3, 8, 50, 900, 570, 7, 0.3, 0.25, 0.5, 2.5, 18, 0.5, 0.5, 0.5, 0.8, 0.8, 0.8, 1.5, 1, 1, 2, 1.5, 1.5, 0.1, 15, False)),
                            ("P90", (20, 11.2, 12, 46, 900, 420, 7, 0.18, 0.4, 0.4, 2, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.25, 1.25, 0.06, 15, False)),
                            ("PDW-R", (25, 14.3, 8, 50, 750, 430, 7, 0.2, 0.2, 0.4, 2, 18, 0.4, 0.4, 0.4, 0.6, 0.6, 0.6, 1.5, 1, 1, 2, 1.5, 1.5, 0.1, 15, False)),
                            ("PKP Pecheneg", (34, 22, 8, 60, 600, 560, 10, 0.65, 0.4, 0.4, 1.5, 13, 0.5, 0.4, 0.2, 1.5, 1.5, 1.5, 5, 4, 3, 6, 5, 4, 0.12, 15, False)),
                            ("PP-19", (16.7, 12.5, 12, 40, 900, 320, 7, 0.2, 0.3, 0.3, 1.5, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.25, 1.25, 0.06, 15, False)),
                            ("PP-2000", (25, 13.75, 12, 50, 650, 360, 7, 0.18, 0.3, 0.2, 2.5, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.25, 1.25, 0.06, 15, False)),
                            ("QBB-95", (25, 18.4, 8, 50, 650, 670, 7, 0.37, 0.3, 0.2, 2, 13, 0.4, 0.4, 0.2, 1, 0.7, 0.7, 3, 2.5, 2, 4, 3.5, 3, 0.1, 15, False)),
                            ("QBU-88", (50, 37.5, 15, 75, 260, 550, 20, 1.5, 0.3, 0.3, 1, 6, 0.025, 0.025, 0.025, 1, 1, 1, 3, 2.5, 2, 4, 3.5, 3, 0.8, 15, True)),
                            ("QBZ-95B", (25, 14.3, 8, 50, 650, 490, 7, 0.2, 0.3, 0.3, 2.5, 13, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 1.5, 1, 1, 2, 1.5, 1.5, 0.1, 15, False)),
                            ("RPK-74M", (25, 18.4, 8, 50, 700, 600, 7, 0.3, 0.2, 0.2, 1.8, 13, 0.4, 0.2, 0.2, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.1, 15, False)),
                            ("SCAR-H", (30, 20, 8, 50, 600, 420, 10, 0.5, 0.2, 0.2, 1.35, 13, 0.3, 0.3, 0.3, 1.2, 1.2, 1.2, 2.5, 2, 1.5, 3, 2.5, 2, 0.12, 15, False)),
                            ("SCAR-L", (25, 18.4, 8, 50, 620, 580, 7, 0.2, 0.225, 0.225, 2.75, 18, 0.2, 0.2, 0.2, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.1, 15, False)),
                            ("SG553", (25, 14.3, 8, 50, 700, 430, 7, 0.25, 0.2, 0.4, 2.2, 18, 0.4, 0.4, 0.4, 0.8, 0.8, 0.8, 2, 1.5, 1, 2.5, 2, 1.5, 0.1, 15, False)),
                            ("SKS", (43, 27, 15, 60, 333, 440, 10, 0.55, 0.3, 0.4, 1, 15, 0.1, 0.1, 0.1, 1, 1, 1, 2.5, 2, 1.5, 3, 2.5, 2, 0.3, 15, True)),
                            ("SV-98", (80, 50, 20, 80, 48, 520, 35, 2, 0, 0, 1, 15, 0, 0, 0, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 1.2, 15, True)),
                            ("SVD", (50, 37.5, 15, 75, 260, 530, 20, 1.5, -0.1, 0.3, 1, 6, 0.0167, 0.0167, 0.0167, 1.5, 1, 1, 3.5, 3, 2.5, 4.5, 4, 3.5, 0.8, 15, True)),
                            ("Type 88 LMG", (25, 18.4, 8, 50, 650, 600, 7, 0.36, 0.3, 0.3, 1.5, 12, 0.5, 0.4, 0.2, 1.5, 1, 1, 5, 4, 3, 6, 5, 4, 0.1, 15, False)),
                            ("UMP45", (34, 12.5, 8, 40, 600, 320, 7, 0.25, 0.2, 0.2, 2.75, 20, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1.5, 1.25, 1.25, 0.06, 15, False))]) #seems that every weapon has a spread recovery rate of 15

weapon_stats_key = OrderedDict([("Max Damage", 0), #for my convenience
                                ("Min Damage", 1),
                                ("Damage Drop-off Start", 2),
                                ("Damage Drop-off End", 3),
                                ("Rate of Fire", 4),
                                ("Muzzle Velocity", 5),
                                ("Suppression", 6),
                                ("Recoil Up", 7),
                                ("Recoil Left", 8),
                                ("Recoil Right", 9),
                                ("First Shot Multiplier", 10),
                                ("Recoil Recovery", 11),
                                ("ADS Stationary Standing Spread", 12),
                                ("ADS Stationary Crouching Spread", 13),
                                ("ADS Stationary Prone Spread", 14),
                                ("ADS Moving Standing Spread", 15),
                                ("ADS Moving Crouching Spread", 16),
                                ("ADS Moving Prone Spread", 17),
                                ("HIP Stationary Standing Spread", 18),
                                ("HIP Stationary Crouching Spread", 19),
                                ("HIP Stationary Prone Spread", 20),
                                ("HIP Moving Standing Spread", 21),
                                ("HIP Moving Crouching Spread", 22),
                                ("HIP Moving Prone Spread", 23),
                                ("Spread Increase", 24),
                                ("Spread Recovery", 25), #I believe that "recoil/spread decrease" is proper term, but "recoil/spread recovery" sounds cooler; some of these terms/practices were carried over from the NetLogo version of this BF3 Weapon Comparison that I made
                                ("sniper", 26)])

weapon_attachments = OrderedDict([(".44 Magnum", (None, None, None, None, None, None, None)), #if the attachment's incompatible, then it has no effect on the weapon
                                  ("93R", (None, None, None, None, None, None, None)),
                                  ("A-91", (None, (0.75, 1.33), (None, 0.8, 1.25), (75, 560, 1.15, 0.25, 1.33), None, 0.5, (4, 35, 280, 0.9, 0.75, 1.67))), #apparently, there's data for A-91's bipod despite being unavailable for use on the weapon in-game
                                  ("ACW-R", ((0.25, 0.67, 0.5, 0.5), (0.75, 1.23), (None, 0.67, 1.34), (75, 650, 1.18, 0.35, 1.3), None, 0.5, (4, 35, 300, 0.85, 0.75, 1.34))),
                                  ("AEK-971", ((0.25, 0.5, 0.25, 0.134), (0.75, 1.2), (None, 0.75, 1.34), (65, None, 1.15, 0.25, 1.2), None, 0.5, (4, 35, 320, 0.9, 0.75, 1.4))), #if the heavy barrel's Muzzle Velocity field is "None", then the HB has no effect on the muzzle velocity of the weapon. I have my reasons.
                                  ("AK-74M", ((0.25, 0.5, 0.25, 0.123), (0.82, 1.2), (None, 0.66, 1.5), (65, None, 1.07, 0.25, 1.2), None, 0.5, (4, 35, 330, 0.9, 0.75, 1.4))),
                                  ("AKS-74U", (None, (0.82, 1.25), (None, 0.67, 1.25), (75, 590, 1.07, 0.25, 1.25), None, 0.5, (4, 35, 290, 0.9, 0.75, 1.5))),
                                  ("AN-94", ((0.25, 0.5, 0.25, 0.134), (0.83, 1.2), (None, 0.66, 1.5), (65, None, 1.1, 0.25, 1.2), None, 0.5, (4, 35, 330, 0.9, 0.75, 1.4))),
                                  ("AS Val", (None, None, None, None, 0.5, None, None)),
                                  ("AUG A3", ((0.25, 0.5, 0.25, 0.123), (0.75, 1.25), (None, 0.75, 1.5), (65, None, 1.15, 0.25, 1.3), None, 0.5, (4, 35, 340, 0.9, 0.75, 1.5))),
                                  ("F2000", ((0.2, 0.5, 0.25, 0.15), (0.8, 1.25), (None, 0.75, 1.25), (65, None, 1.15, 0.25, 1.25), None, 0.5, (4, 35, 380, 0.9, 0.75, 1.5))),
                                  ("FAMAS", ((0.2, 0.35, 0.25, 0.15), (0.84, 1.2), (None, 0.71, 1.25), (65, None, 1.09, 0.25, 1.3), None, 0.5, (4, 35, 380, 0.9, 0.75, 1.4))),
                                  ("G17C", (None, None, None, None, 0.67, None, (6, 40, None, 0.9, 0.75, 1.5))),
                                  ("G18", (None, None, None, None, None, None, (6, 30, None, 0.9, 0.75, 1.5))),
                                  ("G36C", ((0.25, 0.5, 0.25, 0.15), (0.83, 1.25), (None, 0.67, 1.25), (75, 600, 1.1, 0.25, 1.25), None, 0.5, (4, 35, 320, 0.9, 0.75, 1.5))),
                                  ("G3A3", ((0.15, 0.5, 0.25, 0.094), (0.725, 1.143), (None, 0.5, 2), (90, 650, 1.067, 0.25, 1.143), None, 0.5, (4, 35, 300, 0.9, 0.75, 1.285))),
                                  ("G53", (None, (0.82, 1.25), (None, 0.67, 1.25), (75, 600, 1.107, 0.25, 1.25), None, 0.5, (4, 35, 320, 0.9, 0.75, 1.5))),
                                  ("JNG-90", ((0.25, None, 0.25, 0.085), None, None, None, None, 0.5, (None, None, 310, 0.9, None, 1.2))), #odd, the suppressor does not affect damage drop-off distances on bolt action sniper rifles...
                                  ("KH2002", ((0.25, 0.5, 0.25, 0.134), (0.75, 1.25), (None, 0.75, 1.5), (65, None, 1.1, 0.25, 1.25), None, 0.5, (4, 35, 380, 0.9, 0.75, 1.5))),
                                  ("L85A2", ((0.25, 0.5, 0.25, 0.138), (0.75, 1.25), (None, 0.67, 1.5), (65, None, 1.15, 0.25, 1.25), None, 0.5, (4, 35, 380, 0.9, 0.75, 1.5))),
                                  ("L86A2", ((0.2, 0.67, 0.25, 0.042), (0.85, 1.15), (0.9, 0.67, 1.25), (65, None, 1.1, 0.45, 1.17), None, 0.5, (4, 35, 340, 0.9, 0.75, 1.34))), #I got up to here to find out that the foregrip also affects vertical recoil on certain weapons; sigh
                                  ("LSAT", ((0.15, 0.5, 0.2, 0.03), (0.88, 1.12), (0.9, 0.67, 1.2), None, None, 0.5, (4, 35, 330, 0.9, 0.75, 1.24))),
                                  ("M16A3", ((0.25, 0.5, 0.25, 0.123), (0.8, 1.2), (None, 0.75, 1.5), (65, None, 1.15, 0.25, 1.2), None, 0.5, (4, 35, 380, 0.9, 0.75, 1.4))),
                                  ("M16A4", ((0.25, 0.5, 0.25, 0.123), (0.8, 1.2), (None, 0.75, 1.5), (65, None, 1.15, 0.25, 1.2), None, 0.5, (4, 35, 380, 0.9, 0.75, 1.4))), #I'm pretty sure that the M16A4's foregrip should have a different effect compared to M16A3's foregrip; Symthic says the two have the same multipliers
                                  ("M1911", (None, None, None, None, None, None, (6, 40, None, 0.9, 0.75, 1.5))),
                                  ("M240B", ((0.1, 0.25, 0.08, 0.014), (0.71, None), (0.75, 0.8, 1.2), None, None, 0.5, (4, 35, 330, 0.9, 0.75, None))),
                                  ("M249", ((0.1, 0.4, 0.16, 0.03), (0.875, None), (None, 0.75, 1.2), None, None, 0.5, (4, 35, 330, 0.9, 0.75, None))),
                                  ("M27 IAR", ((0.2, 0.35, 0.25, 0.042), (0.85, 1.143), (None, 0.67, 1.25), (65, None, 1.085, 0.5, 1.143), None, 0.57, (4, 35, 340, 0.9, 0.75, 1.143))), #the M27's laser is 7% less effective than all the other primary weapon lasers
                                  ("M39 EMR", ((0.2, None, None, None), None, (0.67, 0.5, 2), None, None, 0.5, (6, 35, 320, 0.9, 0.75, 1.285))), #something's fishy with the data reported for M39's bipod. The actual number reported for the Recoil Up multiplier is 0.20000000298.
                                  ("M4", ((0.25, 0.67, 0.5, 0.5), (0.8, 1.2), (None, 0.75, 1.25), (65, 650, 1.15, 0.25, 1.25), None, 0.5, (4, 35, 330, 0.9, 0.75, 1.5))), #the M4's suppressor reduces muzzle velocity to 330 m/s compared to 320 m/s for the M4A1 suppressor :)
                                  ("M40A5", ((0.2, None, 0.3, 0.085), None, None, None, None, 0.5, (None, None, 310, 0.9, None, None))),
                                  ("M416", ((0.25, 0.4, 0.25, 0.123), (0.82, 1.2), (None, 0.6, 1.5), (65, None, 1.107, 0.25, 1.2), None, 0.5, (4, 35, 330, 0.9, 0.75, 1.4))),
                                  ("M417", ((0.2, None, None, None), None, (0.85, 0.8, 2), None, None, 0.5, (6, 35, 290, 0.95, 0.75, 1.34))),
                                  ("M4A1", ((0.25, 0.67, 0.5, 0.5), (0.8, 1.2), (None, 0.75, 1.25), (65, 650, 1.15, 0.25, 1.25), None, 0.5, (4, 35, 320, 0.9, 0.75, 1.5))), #as previous mentioned with the M16A3 and M16A4, I'm pretty sure that the M4's foregrip should have a different effect compared to the M4A1's foregrip
                                  ("M5K", (None, None, None, None, 0.5, None, (6, 40, 300, 0.88, 0.8, 1.25))), #check M5K Flash Suppressor compatibility
                                  ("M60E4", ((0.1, 0.5, 0.08, 0.014), (0.75, None), (0.85, 0.5, 1.2), None, None, 0.5, (4, 35, 310, 0.9, 0.75, None))),
                                  ("M9", (None, None, None, None, None, None, (6, 40, None, 0.9, 0.75, 1.5))),
                                  ("M98B", ((0.2, None, 0.3, 0.085), None, None, None, None, 0.5, (None, None, 310, 0.9, None, None))),
                                  ("MG36", ((0.15, 0.35, 0.25, 0.042), (0.85, 1.143), (None, 0.67, 1.25), (65, None, 1.067, 0.5, 1.143), None, 0.5, (4, 35, 310, 0.9, 0.75, 1.143))),
                                  ("MK11 MOD 0", ((0.2, None, None, None), None, (0.67, 0.67, 2), None, None, 0.5, (6, 35, 310, 0.9, 0.75, 1.285))),
                                  ("MP412 REX", (None, None, None, None, None, None, None)),
                                  ("MP443", (None, None, None, None, None, None, (6, 40, None, 0.9, 0.75, 1.5))),
                                  ("MP7", (None, None, None, None, None, 0.5, (6, 40, 270, 0.9, 0.8, 1.5))), #just took me this long to realize. The reason why there is data on incompatible attachments is because the attachments are available in singleplayer :p
                                  ("MTAR-21", (None, (0.84, 1.34), (None, 0.8, 1.2), (75, 650, 1.1, 0.25, 1.33), None, 0.5, (4, 35, 320, 0.9, 0.75, 1.5))),
                                  ("P90", (None, (0.82, 1.25), None, None, None, 0.5, (6, 40, 280, 0.9, 0.8, 1.5))),
                                  ("PDW-R", (None, None, None, None, None, 0.5, (4, 35, 280, 0.9, 0.75, 1.67))),
                                  ("PKP Pecheneg", ((0.1, 0.34, 0.08, 0.014), (0.7, None), (0.77, 0.75, 1.2), None, None, 0.5, (4, 35, 330, 0.9, 0.75, None))), #Symthic erroneously reports no change in muzzle velocity with PKP Pecheneg's suppressor
                                  ("PP-19", (None, (0.82, 1.25), None, None, None, 0.5, (6, 32, 280, 0.9, 0.8, 1.5))), #Symthic, again, like above, reports no change in muzzle velocity with the PP-19's suppressor
                                  ("PP-2000", (None, (0.82, 1.25), None, None, None, 0.5, (6, 40, 280, 0.9, 0.8, 1.5))),
                                  ("QBB-95", ((0.2, 0.34, 0.25, 0.12), (0.865, 1.143), (None, 0.67, 1.25), (65, None, 1.081, 0.5, 1.168), None, 0.5, (4, 35, 340, 0.9, 0.75, 1.167))),
                                  ("QBU-88", ((0.2, None, None, None), None, (0.67, 0.67, 2), None, None, 0.5, (6, 45, 310, 0.9, 0.75, 1.334))),
                                  ("QBZ-95B", (None, (0.75, 1.33), None, (75, 650, 1.15, 0.25, 1.33), 0.5, None, (4, 35, 330, 0.9, 0.75, 1.67))),
                                  ("RPK-74M", ((0.2, 0.75, 0.25, 0.042), (0.833, 1.143), (None, 0.5, 1.25), (65, None, 1.1, 0.5, 1.143), None, 0.5, (4, 35, 330, 0.9, 0.75, 1.143))),
                                  ("SCAR-H", ((0.25, 0.5, 0.25, 0.123), (0.725, 1.2), (None, 0.5, 1.34), (75, 560, 1.06, 0.25, 1.2), None, 0.5, (4, 35, 320, 0.9, 0.75, 1.4))),
                                  ("SCAR-L", ((0.25, 0.67, 0.25, 0.094), (0.75, 1.2), (None, 0.58, 1.5), (65, 640, 1.15, 0.25, 1.3), None, 0.5, (4, 35, 320, 0.9, 0.75, 1.3))),
                                  ("SG553", ((0.25, 0.5, 0.25, 0.15), (0.8, 1.25), (None, 0.75, 1.25), (75, 570, 1.12, 0.25, 1.25), None, 0.5, (4, 35, 320, 0.9, 0.75, 1.5))),
                                  ("SKS", ((0.25, 0.5, 0.285, 0.133), (0.85, 1.2), (0.82, 0.75, 2), (None, 590, 1.1, 0.25, 1.2), None, 0.5, (6, 45, 380, 0.9, 0.75, 1.4))),
                                  ("SV-98", ((0.2, None, 0.3, 0.085), None, None, None, None, 0.5, (None, None, 310, 0.9, None, 1.143))), #SV-98's bipod reduces ADS spread but the only spread that occurs in sniper rifles is when one moves but the bipod doesn't come into effect then...
                                  ("SVD", ((0.2, None, None, None), None, (0.67, 0.67, 2), None, None, 0.5, (6, 35, 310, 0.9, 0.75, 1.285))),
                                  ("Type 88 LMG", ((0.1, 0.4, 0.16, 0.03), (0.9, None), (None, 0.67, 1.2), None, None, 0.5, (4, 35, 380, 0.9, 0.75, None))),
                                  ("UMP45", (None, (0.8, 1.25), None, None, 0.5, None, (4, 32, None, 0.9, 0.8, 1.5)))])

weapon_attachments_key = OrderedDict([("Bipod", 0), #I realize that this has a greater use than just my own convenience; I can avoid having to key [("Bipod", ...), ("Flash Suppressor", ...), ("Foregrip", ...), ...] for every weapon
                                      ("Flash Suppressor", 1),
                                      ("Foregrip", 2),
                                      ("Heavy Barrel", 3),
                                      ("Laser Sight (Primary)", 4),
                                      ("Laser Sight", 5),
                                      ("Suppressor", 6)])
################################################################################
top_table = '<table><tr><td><img src="images/weapons/' + data["Weapon 1"].value.replace(".", "") + '.png"><br><center>'
if (((data["Weapon 1 Primary Attachment"].value != "None") and (data["Weapon 1 Secondary Attachment"].value == "None")) and (weapon_attachments[data["Weapon 1"].value][weapon_attachments_key[data["Weapon 1 Primary Attachment"].value]] != None)):
    weapon_1_name = data["Weapon 1"].value + " " + data["Weapon 1 Primary Attachment"].value
    top_table += weapon_1_name + "</center></td>" #replace to take care of the ".44 Magnum" issue. Image will not show up with the period
elif (((data["Weapon 1 Primary Attachment"].value == "None") and (data["Weapon 1 Secondary Attachment"].value != "None")) and (weapon_attachments[data["Weapon 1"].value][weapon_attachments_key[data["Weapon 1 Secondary Attachment"].value]] != None)):
    weapon_1_name = data["Weapon 1"].value + " " + data["Weapon 1 Secondary Attachment"].value
    top_table += weapon_1_name + "</center></td>"
elif (((data["Weapon 1 Primary Attachment"].value != "None") and (data["Weapon 1 Secondary Attachment"].value != "None")) and ((weapon_attachments[data["Weapon 1"].value][weapon_attachments_key[data["Weapon 1 Primary Attachment"].value]] != None) and (weapon_attachments[data["Weapon 1"].value][weapon_attachments_key[data["Weapon 1 Secondary Attachment"].value]] != None))):
    weapon_1_name = data["Weapon 1"].value + " " + data["Weapon 1 Primary Attachment"].value + " + " + data["Weapon 1 Secondary Attachment"].value
    top_table += weapon_1_name + "</center></td>"
else:
    weapon_1_name = data["Weapon 1"].value
    top_table += weapon_1_name + "</center></td>"

top_table += "<th>" + "&nbsp;" * 4 + "versus" + "&nbsp;" * 4 + '</th><td><img src="images/weapons/' + data["Weapon 2"].value.replace(".", "") + '.png"><br><center>'
if (((data["Weapon 2 Primary Attachment"].value != "None") and (data["Weapon 2 Secondary Attachment"].value == "None")) and (weapon_attachments[data["Weapon 2"].value][weapon_attachments_key[data["Weapon 2 Primary Attachment"].value]] != None)):
    weapon_2_name = data["Weapon 2"].value + " " + data["Weapon 2 Primary Attachment"].value
    top_table += weapon_2_name + "</center></td>"
elif (((data["Weapon 2 Primary Attachment"].value == "None") and (data["Weapon 2 Secondary Attachment"].value != "None")) and (weapon_attachments[data["Weapon 2"].value][weapon_attachments_key[data["Weapon 2 Secondary Attachment"].value]] != None)):
    weapon_2_name = data["Weapon 2"].value + " " + data["Weapon 2 Secondary Attachment"].value
    top_table += weapon_2_name + "</center></td>"
elif (((data["Weapon 2 Primary Attachment"].value != "None") and (data["Weapon 2 Secondary Attachment"].value != "None")) and ((weapon_attachments[data["Weapon 2"].value][weapon_attachments_key[data["Weapon 2 Primary Attachment"].value]] != None) and (weapon_attachments[data["Weapon 2"].value][weapon_attachments_key[data["Weapon 2 Secondary Attachment"].value]] != None))):
    weapon_2_name = data["Weapon 2"].value + " " + data["Weapon 2 Primary Attachment"].value + " + " + data["Weapon 2 Secondary Attachment"].value
    top_table += weapon_2_name + "</center></td>"
else:
    weapon_2_name = data["Weapon 2"].value
    top_table += weapon_2_name + "</center></td>"
top_table += "</td></tr></table><br>\n"
################################################################################
weapon_1 = apply_weapon_attachments(data["Weapon 1"].value, data["Weapon 1 Primary Attachment"].value, data["Weapon 1 Secondary Attachment"].value)
weapon_2 = apply_weapon_attachments(data["Weapon 2"].value, data["Weapon 2 Primary Attachment"].value, data["Weapon 2 Secondary Attachment"].value)
################################################################################
weapon_1_table_data = list(weapon_1)
weapon_2_table_data = list(weapon_2) #for some damn reason, weapon_1 and weapon_2 are modified with the changes made to weapon_1_table_data and weapon_2_table_data when weapon_1 and weapon_2 are returned as a list. Function modifed to return a tuple instead.
i = 0
while (i < len(weapon_1_table_data)):
    if (i in [0, 1, 2, 3, 4, 5, 6, 11, 25]):
        if (weapon_1_table_data[i] > weapon_2_table_data[i]):
            weapon_1_table_data[i] = "<td><b>" + str(weapon_1_table_data[i]) + "</b></td>"
            weapon_2_table_data[i] = "<td>" + str(weapon_2_table_data[i]) + "</td>"
        elif (weapon_2_table_data[i] > weapon_1_table_data[i]):
            weapon_1_table_data[i] = "<td>" + str(weapon_1_table_data[i]) + "</td>"
            weapon_2_table_data[i] = "<td><b>" + str(weapon_2_table_data[i]) + "</b></td>"
        else:
            weapon_1_table_data[i] = "<td>" + str(weapon_1_table_data[i]) + "</td>"
            weapon_2_table_data[i] = "<td>" + str(weapon_2_table_data[i]) + "</td>"
    else:
        if (weapon_1_table_data[i] < weapon_2_table_data[i]):
            weapon_1_table_data[i] = "<td><b>" + str(weapon_1_table_data[i]) + "</b></td>"
            weapon_2_table_data[i] = "<td>" + str(weapon_2_table_data[i]) + "</td>"
        elif (weapon_2_table_data[i] < weapon_1_table_data[i]):
            weapon_1_table_data[i] = "<td>" + str(weapon_1_table_data[i]) + "</td>"
            weapon_2_table_data[i] = "<td><b>" + str(weapon_2_table_data[i]) + "</b></td>"
        else:
            weapon_1_table_data[i] = "<td>" + str(weapon_1_table_data[i]) + "</td>"
            weapon_2_table_data[i] = "<td>" + str(weapon_2_table_data[i]) + "</td>"
    i += 1
weapon_comparison_table = '<table border="1">\n\t<tr><th>Stat</th><th>' + data["Weapon 1"].value + "</th><th>" + data["Weapon 2"].value + "</th></tr>\n"
i = 0
for stat in weapon_stats_key.keys()[:len(weapon_stats_key) - 2]:
    weapon_comparison_table += "\t<tr><td>" + stat + "</td>" + weapon_1_table_data[i] + weapon_2_table_data[i] + "</tr>\n"
    i += 1
weapon_comparison_table += "</table><br>\n"
del weapon_1_table_data
del weapon_2_table_data #saves memory?
################################################################################
hits_range = range(int(min(ceil(100.0 / weapon_1[weapon_stats_key["Max Damage"]]), ceil(100.0 / weapon_2[weapon_stats_key["Max Damage"]]))),
                   int(max(ceil(100.0 / weapon_1[weapon_stats_key["Min Damage"]]), ceil(100.0 / weapon_2[weapon_stats_key["Min Damage"]])) + 1))
hits_to_kill_distance_table = '<b>Maximum distance where a <i>x</i>-hit kill can be achieved</b>\n<table border="1">\n\t<tr><th>Hits to Kill</th>'
weapon_1_hits_to_kill_distance_table_data = []
weapon_2_hits_to_kill_distance_table_data = []
for hits in hits_range:
    hits_to_kill_distance_table += "<th>" + str(hits) + "</th>"
    weapon_1_hits_to_kill_distance_table_data.append(hits_to_kill_distance(weapon_1[weapon_stats_key["Max Damage"]], weapon_1[weapon_stats_key["Min Damage"]], weapon_1[weapon_stats_key["Damage Drop-off Start"]], weapon_1[weapon_stats_key["Damage Drop-off End"]], weapon_1[weapon_stats_key["Muzzle Velocity"]], hits, weapon_1[weapon_stats_key["sniper"]]))
    weapon_2_hits_to_kill_distance_table_data.append(hits_to_kill_distance(weapon_2[weapon_stats_key["Max Damage"]], weapon_2[weapon_stats_key["Min Damage"]], weapon_2[weapon_stats_key["Damage Drop-off Start"]], weapon_2[weapon_stats_key["Damage Drop-off End"]], weapon_2[weapon_stats_key["Muzzle Velocity"]], hits, weapon_2[weapon_stats_key["sniper"]]))
hits_to_kill_distance_table += "</tr>\n"
i = 0
while (i < len(weapon_1_hits_to_kill_distance_table_data)):
    if (weapon_1_hits_to_kill_distance_table_data[i] > weapon_2_hits_to_kill_distance_table_data[i]):
        if (type(weapon_1_hits_to_kill_distance_table_data[i]) == type(1)):
            weapon_1_hits_to_kill_distance_table_data[i] = "<td><b>" + str(weapon_1_hits_to_kill_distance_table_data[i]) + "</b></td>"
        else:
            weapon_1_hits_to_kill_distance_table_data[i] = "<td><b>" + str(round(weapon_1_hits_to_kill_distance_table_data[i], 2)) + "</b></td>"
        if (type(weapon_2_hits_to_kill_distance_table_data[i]) == type(1)):
            weapon_2_hits_to_kill_distance_table_data[i] = "<td>" + str(weapon_2_hits_to_kill_distance_table_data[i]) + "</td>"
        else:
            weapon_2_hits_to_kill_distance_table_data[i] = "<td>" + str(round(weapon_2_hits_to_kill_distance_table_data[i], 2)) + "</td>"
    elif (weapon_2_hits_to_kill_distance_table_data[i] > weapon_1_hits_to_kill_distance_table_data[i]):
        if (type(weapon_1_hits_to_kill_distance_table_data[i]) == type(1)):
            weapon_1_hits_to_kill_distance_table_data[i] = "<td>" + str(weapon_1_hits_to_kill_distance_table_data[i]) + "</td>"
        else:
            weapon_1_hits_to_kill_distance_table_data[i] = "<td>" + str(round(weapon_1_hits_to_kill_distance_table_data[i], 2)) + "</td>"
        if (type(weapon_2_hits_to_kill_distance_table_data[i]) == type(1)):
            weapon_2_hits_to_kill_distance_table_data[i] = "<td><b>" + str(weapon_2_hits_to_kill_distance_table_data[i]) + "</b></td>"
        else:
            weapon_2_hits_to_kill_distance_table_data[i] = "<td><b>" + str(round(weapon_2_hits_to_kill_distance_table_data[i], 2)) + "</b></td>"
    else:
        if (type(weapon_1_hits_to_kill_distance_table_data[i]) == type(1)):
            weapon_1_hits_to_kill_distance_table_data[i] = "<td>" + str(weapon_1_hits_to_kill_distance_table_data[i]) + "</td>"
        else:
            weapon_1_hits_to_kill_distance_table_data[i] = "<td>" + str(round(weapon_1_hits_to_kill_distance_table_data[i], 2)) + "</td>"
        if (type(weapon_2_hits_to_kill_distance_table_data[i]) == type(1)):
            weapon_2_hits_to_kill_distance_table_data[i] = "<td>" + str(weapon_2_hits_to_kill_distance_table_data[i]) + "</td>"
        else:
            weapon_2_hits_to_kill_distance_table_data[i] = "<td>" + str(round(weapon_2_hits_to_kill_distance_table_data[i], 2)) + "</td>"
    #yeah, yeah, I know this feels a bit redundant after what I did above:
    if (weapon_1_hits_to_kill_distance_table_data[i] in ("<td>0</td>", "<td><b>0</b></td>")):
        weapon_1_hits_to_kill_distance_table_data[i] = weapon_1_hits_to_kill_distance_table_data[i].replace("0", "-")
    if (weapon_2_hits_to_kill_distance_table_data[i] in ("<td>0</td>", "<td><b>0</b></td>")):
        weapon_2_hits_to_kill_distance_table_data[i] = weapon_2_hits_to_kill_distance_table_data[i].replace("0", "-")
    i += 1

hits_to_kill_distance_table += "\t<tr><th>" + weapon_1_name + "</th>"
for distances in weapon_1_hits_to_kill_distance_table_data:
    hits_to_kill_distance_table += distances
hits_to_kill_distance_table += "</tr>\n\t<tr><th>" + weapon_2_name + "</th>"
for distances in weapon_2_hits_to_kill_distance_table_data:
    hits_to_kill_distance_table += distances
hits_to_kill_distance_table += "</tr>\n</table><br>\n"
del weapon_1_hits_to_kill_distance_table_data
del weapon_2_hits_to_kill_distance_table_data
################################################################################
ttk_table = '<b>Time to Kill</b>\n<table border="1">\n\t<tr><th>Distance</th>'
ttk_hc_table = '<b>Time to Kill (Hardcore)</b>\n<table border="1">\n\t<tr><th>Distance</th>'
weapon_1_ttk_table_data = []
weapon_2_ttk_table_data = []
weapon_1_ttk_hc_table_data = []
weapon_2_ttk_hc_table_data = []
for distance in range(0, 101):
    ttk_table += "<th>" + str(distance) + "</th>"
    ttk_hc_table += "<th>" + str(distance) + "</th>"
    weapon_1_ttk_table_data.append(ttk(weapon_1[weapon_stats_key["Max Damage"]], weapon_1[weapon_stats_key["Min Damage"]], weapon_1[weapon_stats_key["Damage Drop-off Start"]], weapon_1[weapon_stats_key["Damage Drop-off End"]], weapon_1[weapon_stats_key["Rate of Fire"]], weapon_1[weapon_stats_key["Muzzle Velocity"]], distance))
    weapon_2_ttk_table_data.append(ttk(weapon_2[weapon_stats_key["Max Damage"]], weapon_2[weapon_stats_key["Min Damage"]], weapon_2[weapon_stats_key["Damage Drop-off Start"]], weapon_2[weapon_stats_key["Damage Drop-off End"]], weapon_2[weapon_stats_key["Rate of Fire"]], weapon_2[weapon_stats_key["Muzzle Velocity"]], distance))
    weapon_1_ttk_hc_table_data.append(ttk(weapon_1[weapon_stats_key["Max Damage"]], weapon_1[weapon_stats_key["Min Damage"]], weapon_1[weapon_stats_key["Damage Drop-off Start"]], weapon_1[weapon_stats_key["Damage Drop-off End"]], weapon_1[weapon_stats_key["Rate of Fire"]], weapon_1[weapon_stats_key["Muzzle Velocity"]], distance, health=60.000004)) #Yes.
    weapon_2_ttk_hc_table_data.append(ttk(weapon_2[weapon_stats_key["Max Damage"]], weapon_2[weapon_stats_key["Min Damage"]], weapon_2[weapon_stats_key["Damage Drop-off Start"]], weapon_2[weapon_stats_key["Damage Drop-off End"]], weapon_2[weapon_stats_key["Rate of Fire"]], weapon_2[weapon_stats_key["Muzzle Velocity"]], distance, health=60.000004))
ttk_table += "</tr>\n"
ttk_hc_table += "</tr>\n"
i = 0
while (i < len(weapon_1_ttk_table_data)):
    if (weapon_1_ttk_table_data[i] < weapon_2_ttk_table_data[i]):
        weapon_1_ttk_table_data[i] = "<td><b>" + str(round(weapon_1_ttk_table_data[i], 1)) + "</b></td>"
        weapon_2_ttk_table_data[i] = "<td>" + str(round(weapon_2_ttk_table_data[i], 1)) + "</td>"
    elif (weapon_2_ttk_table_data[i] < weapon_1_ttk_table_data[i]):
        weapon_1_ttk_table_data[i] = "<td>" + str(round(weapon_1_ttk_table_data[i], 1)) + "</td>"
        weapon_2_ttk_table_data[i] = "<td><b>" + str(round(weapon_2_ttk_table_data[i], 1)) + "</b></td>"
    else:
        weapon_1_ttk_table_data[i] = "<td>" + str(round(weapon_1_ttk_table_data[i], 1)) + "</td>"
        weapon_2_ttk_table_data[i] = "<td>" + str(round(weapon_2_ttk_table_data[i], 1)) + "</td>"
    if (weapon_1_ttk_hc_table_data[i] < weapon_2_ttk_hc_table_data[i]):
        weapon_1_ttk_hc_table_data[i] = "<td><b>" + str(round(weapon_1_ttk_hc_table_data[i], 1)) + "</b></td>"
        weapon_2_ttk_hc_table_data[i] = "<td>" + str(round(weapon_2_ttk_hc_table_data[i], 1)) + "</td>"
    elif (weapon_2_ttk_hc_table_data[i] < weapon_1_ttk_hc_table_data[i]):
        weapon_1_ttk_hc_table_data[i] = "<td>" + str(round(weapon_1_ttk_hc_table_data[i], 1)) + "</td>"
        weapon_2_ttk_hc_table_data[i] = "<td><b>" + str(round(weapon_2_ttk_hc_table_data[i], 1)) + "</b></td>"
    else:
        weapon_1_ttk_hc_table_data[i] = "<td>" + str(round(weapon_1_ttk_hc_table_data[i], 1)) + "</td>"
        weapon_2_ttk_hc_table_data[i] = "<td>" + str(round(weapon_2_ttk_hc_table_data[i], 1)) + "</td>"
    i += 1
    
ttk_table += "\t<tr><th>" + weapon_1_name + "</th>"
for times in weapon_1_ttk_table_data:
    ttk_table += times
ttk_table += "</tr>\n\t<tr><th>" + weapon_2_name + "</th>"
for times in weapon_2_ttk_table_data:
    ttk_table += times
ttk_table += "</tr>\n</table><br>\n"

ttk_hc_table += "\t<tr><th>" + weapon_1_name + "</th>"
for times in weapon_1_ttk_hc_table_data:
    ttk_hc_table += times
ttk_hc_table += "</tr>\n\t<tr><th>" + weapon_2_name + "</th>"
for times in weapon_2_ttk_hc_table_data:
    ttk_hc_table += times
ttk_hc_table += "</tr>\n</table><br>\n"
del weapon_1_ttk_table_data
del weapon_2_ttk_table_data
del weapon_1_ttk_hc_table_data
del weapon_2_ttk_hc_table_data

weapon_1_ttk_graph_name = weapon_1_name.replace("+ ", "")
weapon_2_ttk_graph_name = weapon_2_name.replace("+ ", "")
for attachment in (" Bipod", " Flash Suppressor", " Foregrip", " Laser Sight (Primary)", " Laser Sight"):
    weapon_1_ttk_graph_name = weapon_1_ttk_graph_name.replace(attachment, "")
    weapon_2_ttk_graph_name = weapon_2_ttk_graph_name.replace(attachment, "")

ttk_graphs = '<b>Time to Kill (Graph)</b><br>\n<img src="images/ttk_graphs/' + weapon_1_ttk_graph_name.replace(".", "") + '.png" width="750"> <img src="images/ttk_graphs/' + weapon_2_ttk_graph_name.replace(".", "") + '.png" width="750"><br>\n<i>Tip: Open the images in a new tab/window for a larger view.</i><br>\n'
################################################################################
#this is the only part where the HTML is not formatted consistently; ain't nobody got time to fix this
weapon_attachments_effects_table = ""
if (not ((data["Weapon 1 Primary Attachment"].value == "None") and (data["Weapon 1 Secondary Attachment"].value == "None") and (data["Weapon 2 Primary Attachment"].value == "None") and (data["Weapon 2 Secondary Attachment"].value == "None"))):
    weapon_attachments_effects_table += '<b>Weapon Attachment Effects</b><br>\n<table>\n\t<tr><th valign="top">\n\t\t' + weapon_attachment_effects_table(data["Weapon 1"].value, data["Weapon 1 Primary Attachment"].value) + "\t\t</th>\n"
    weapon_attachments_effects_table += '\n\t\t<th valign="top">\n\t\t' + weapon_attachment_effects_table(data["Weapon 1"].value, data["Weapon 1 Secondary Attachment"].value) + "\t\t</th>"
    weapon_attachments_effects_table += '\n\t\t<th valign="top">\n\t\t' + weapon_attachment_effects_table(data["Weapon 2"].value, data["Weapon 2 Primary Attachment"].value) + "\t\t</th>"
    weapon_attachments_effects_table += '\n\t\t<th valign="top">\n\t\t' + weapon_attachment_effects_table(data["Weapon 2"].value, data["Weapon 2 Secondary Attachment"].value) + "\t\t</th></tr>\n</table><br>\n"
################################################################################
weapon_1_plot_name = weapon_1_name.replace(" + Laser Sight", "")
weapon_1_plot_name = weapon_1_plot_name.replace("Laser Sight + ", "")
weapon_1_plot_name = weapon_1_plot_name.replace(" Laser Sight", "")
weapon_2_plot_name = weapon_2_name.replace(" + Laser Sight", "")
weapon_2_plot_name = weapon_2_plot_name.replace("Laser Sight + ", "")
weapon_2_plot_name = weapon_2_plot_name.replace(" Laser Sight", "")

plots = '<b>Plots</b><br>\n<img src="images/plots/' + weapon_1_plot_name.replace(".", "") + '.png" width="750"> <img src="images/plots/' + weapon_2_plot_name + '.png" width="750"><br>'
################################################################################
print "<html>\n<head>\n<title>Battlefield 3 Weapon Comparison</title>\n</head>\n<body>\n<center><h1>Battlefield 3 Weapon Comparison</h1>\nby Sean Yip</center>"
print "<center>\n" + top_table + weapon_comparison_table + weapon_attachments_effects_table + hits_to_kill_distance_table + ttk_graphs + ttk_table + ttk_hc_table + plots + "</center>"
print "<i>Time elapsed: " + str(clock()) + " s<br>That is as precise as the Python implementation on this server as it will get.</i>\n" + "</body>\n</html>"

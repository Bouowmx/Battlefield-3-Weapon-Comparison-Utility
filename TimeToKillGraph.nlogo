globals [_color]

to-report damage [max_damage min_damage damage_do_start damage_do_end _distance]
  if (_distance <= damage_do_start) [report max_damage]
  if (_distance >= damage_do_end) [report min_damage]
  report (max_damage + ((min_damage - max_damage) / (damage_do_end - damage_do_start)) * (_distance - damage_do_start))
end

to graph [weapon max_damage min_damage damage_do_start damage_do_end rate_of_fire muzzle_velocity]
  set-current-plot "Time to Kill"
  create-temporary-plot-pen weapon
  set-plot-pen-color _color
  let current_distance 0
  while [current_distance <= 100] [
    plotxy current_distance (1000 * (((60 / rate_of_fire) * ((ceiling (100 / (damage max_damage min_damage damage_do_start damage_do_end current_distance))) - 1)) + (current_distance / muzzle_velocity)))
    set current_distance (current_distance + 0.1)
  ]
end
@#$#@#$#@
GRAPHICS-WINDOW
6
10
251
119
-1
-1
39.0
1
10
1
1
1
0
1
1
1
0
1
0
1
0
0
0
ticks
30.0

PLOT
0
0
600
300
Time to Kill
Distance (m)
Time to Kill (ms)
0.0
100.0
0.0
1.0
true
true
"" ""
PENS

@#$#@#$#@
@#$#@#$#@
default
true
0
Polygon -7500403 true true 150 5 40 250 150 205 260 250

@#$#@#$#@
NetLogo 5.0.5
@#$#@#$#@
@#$#@#$#@
@#$#@#$#@
@#$#@#$#@
@#$#@#$#@
default
0.0
-0.2 0 0.0 1.0
0.0 1 1.0 0.0
0.2 0 0.0 1.0
link direction
true
0
Line -7500403 true 150 150 90 180
Line -7500403 true 150 150 210 180

@#$#@#$#@
0
@#$#@#$#@

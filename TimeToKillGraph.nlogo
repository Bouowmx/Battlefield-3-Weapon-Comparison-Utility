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
43
-1
-1
1.0
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
6
10
762
377
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
## WHAT IS IT?

(a general understanding of what the model is trying to show or explain)

## HOW IT WORKS

(what rules the agents use to create the overall behavior of the model)

## HOW TO USE IT

(how to use the model, including a description of each of the items in the Interface tab)

## THINGS TO NOTICE

(suggested things for the user to notice while running the model)

## THINGS TO TRY

(suggested things for the user to try to do (move sliders, switches, etc.) with the model)

## EXTENDING THE MODEL

(suggested things to add or change in the Code tab to make the model more complicated, detailed, accurate, etc.)

## NETLOGO FEATURES

(interesting or unusual features of NetLogo that the model uses, particularly in the Code tab; or where workarounds were needed for missing features)

## RELATED MODELS

(models in the NetLogo Models Library and elsewhere which are of related interest)

## CREDITS AND REFERENCES

(a reference to the model's URL on the web if it has one, as well as any other necessary credits, citations, and links)
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

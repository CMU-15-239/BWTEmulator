Overview
-----------------------------------------------------
assets/: All assets go here. Backgrounds, images, etc.


Files
=====================================================
input\_mapping.json:
  -Contains the mapping from user input to bytecode produced
  -Encoding as follows:
    -_l, _r  : Main left and right buttons, respectively
    -_jx     : Button x of the jumbo buttons
    -_sx_y   : Button y of slate x, where slates are numbered left-to-right,
               top-to-bottom (e.g. 1  2  3  ... 16
                                   17 18 19 ... 32)
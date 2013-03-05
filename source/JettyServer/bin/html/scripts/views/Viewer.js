/** @file Viewer.js
 *  @brief General js file to handle js-related views.
 *
 *  @author Lucas Ray (ltray@cmu.edu)
 */
$(document).ready(function() {
  "use strict";

  /** @brief Shows the loading screen.
   */
  window.show_loading = function show_loading() {
    $("#main").hide();
    $("#loading").show();
  };

  /** @brief Hides the loading screen.
   */
  window.hide_loading = function hide_loading() {
    $("#loading").hide();
    $("#main").show();
  };
});

package eu.darken.apl.search.ui.actions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import eu.darken.apl.R
import eu.darken.apl.common.WebpageTool
import eu.darken.apl.common.uix.BottomSheetDialogFragment2
import eu.darken.apl.databinding.SearchActionDialogBinding
import javax.inject.Inject

@AndroidEntryPoint
class SearchActionDialog : BottomSheetDialogFragment2() {

    override val vm: SearchActionViewModel by viewModels()
    override lateinit var ui: SearchActionDialogBinding
    @Inject lateinit var webpageTool: WebpageTool

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        ui = SearchActionDialogBinding.inflate(inflater, container, false)
        return ui.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        vm.state.observe2(ui) { state ->
            val aircraft = state.aircraft

            aircraftDetails.apply {
                setAircraft(aircraft, state.distanceInMeter)
                onThumbnailClicked = { webpageTool.open(it.link) }
            }

            addAlertAction.text = if (state.alert != null) {
                getString(R.string.alerts_alert_edit_label)
            } else {
                getString(R.string.alerts_alert_add_label)
            }
        }

        ui.showMapAction.setOnClickListener { vm.showMap() }
        ui.addAlertAction.setOnClickListener { vm.showAlert() }

        vm.events.observe2(ui) { event ->

        }

        super.onViewCreated(view, savedInstanceState)
    }
}
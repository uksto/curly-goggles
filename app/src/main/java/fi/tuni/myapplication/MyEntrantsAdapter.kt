package fi.tuni.myapplication;

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Custom adapter to show Rally event entrants
 *
 * @author Otto Kujala
 *
 */
class MyEntrantAdapter(context: Context, resource: Int, private val arrayList:ArrayList<Entrant>) : ArrayAdapter<Entrant>(context, resource, arrayList) {
    private lateinit var eventcount: TextView
    private lateinit var driver: TextView
    private lateinit var nation: TextView
    private lateinit var manifacturer: TextView
    private lateinit var entrantclass: TextView
    private lateinit var name: TextView
    private lateinit var vehicle: TextView
    private lateinit var status: TextView

    /**
     * Add Event to list
     * @param item Entrant object
     */
    fun add(item: Entrant) {
        arrayList.add(item)
    }

    /**
     * get List of Entrants
     * @return List of Entrants
     */
    fun getList(): ArrayList<Entrant> {
        return arrayList
    }

    /**
     * get Entrant
     * @param position position of Entrant in a list
     * @return Entrant object
     */
    override fun getItem(position: Int): Entrant {
        return arrayList[position]
    }

    /**
     * get Entrant id in list
     * @param position position of Entrant in a list
     * @return Entrant id in list
     */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "SetTextI18n")
    /**
     * get Entrant id in list
     * @param position position of Entrant in a list
     * @param convertView view that has been passed
     * @param parent parent view group
     * @return ListView item with data inserted
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertview = convertView
        convertview = LayoutInflater.from(context).inflate(R.layout.entrant_item, parent, false)
        eventcount = convertview.findViewById(R.id.countTextView)
        driver = convertview.findViewById(R.id.driverTextView)
        nation = convertview.findViewById(R.id.nationTextView)
        manifacturer = convertview.findViewById(R.id.manifacturerTextView)
        entrantclass = convertview.findViewById(R.id.classTextView)
        name = convertview.findViewById(R.id.nameTextView)
        vehicle = convertview.findViewById(R.id.vehicleTextView)
        status = convertview.findViewById(R.id.statusTextView)

        eventcount.text = (position + 1).toString()
        driver.text = arrayList[position].driver?.fullName
        nation.text = "Nationality: " + arrayList[position].driver?.country?.name
        manifacturer.text = "Manifacturer: " + arrayList[position].manufacturer?.name
        entrantclass.text = "Class: " + arrayList[position].group?.name
        name.text = "Team: " + arrayList[position].entrant?.name
        vehicle.text = "Car : " + arrayList[position].vehicleModel
        status.text = "Status : " + arrayList[position].status
        return convertview
    }
}
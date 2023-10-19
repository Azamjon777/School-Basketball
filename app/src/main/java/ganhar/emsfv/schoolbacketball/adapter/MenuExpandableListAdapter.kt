package ganhar.emsfv.schoolbacketball.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class MenuExpandableListAdapter(
    private val context: Context,
    private val menuItems: List<String>,
    private val submenuItems: Map<String, List<String>>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return menuItems.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return submenuItems[menuItems[groupPosition]]?.size ?: 0
    }

    override fun getGroup(groupPosition: Int): Any {
        return menuItems[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return submenuItems[menuItems[groupPosition]]?.get(childPosition) ?: ""
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_expandable_list_item_1, parent, false)
        val titleTextView = view.findViewById<TextView>(android.R.id.text1)
        titleTextView.text = getGroup(groupPosition).toString()
        return view
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        val titleTextView = view.findViewById<TextView>(android.R.id.text1)
        titleTextView.text = getChild(groupPosition, childPosition).toString()
        return view
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}

package me.piebridge.donation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import me.piebridge.brevent.ui.AbstractDialogFragment;

/**
 * wechat donation guide
 * <p>
 * Created by thom on 2017/2/13.
 */
public class WechatFragment extends AbstractDialogFragment implements DialogInterface.OnClickListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getString(R.string.donation_wechat_guide));
        builder.setPositiveButton(R.string.donation_wechat_scan, this);
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        DonateActivity activity = (DonateActivity) getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent.setPackage(DonateActivity.PACKAGE_WECHAT);
        intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        activity.startActivity(intent);
    }

}
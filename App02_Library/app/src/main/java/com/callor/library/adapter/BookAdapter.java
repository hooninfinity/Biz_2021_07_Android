package com.callor.library.adapter;

import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.library.databinding.ActivityMainBinding;
import com.callor.library.databinding.BookItemViewBinding;
import com.callor.library.model.BookDTO;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BookDTO> bookList;

    public BookAdapter(List<BookDTO> bookDTOList) {
        this.bookList = bookDTOList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        BookItemViewBinding  bookItemViewBinding
                = BookItemViewBinding.inflate(
                        layoutInflater,
                        parent,false);

        RecyclerView.ViewHolder viewHolder
                = new BookViewHolder(bookItemViewBinding);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BookViewHolder bookHolder = (BookViewHolder) holder;
        BookDTO bookDTO = bookList.get(position);

        TextView txt_title = bookHolder.bookItemView.itemTxtTitle;
        /**
         * HtmlCompat.fromHtml()
         * 문자열 내에 HTML tag가 포함되어 있으면
         * tag 의 효과를 적용하여 문자열을 화면에 그리기 위한 변환 method
         * Nougat(7.0) 이상에서만 작동되는 method
         * Nougat 이하에서는 원래는 작동되었는데 최근 Android에서는 제거되었다.
         */
        String strTitle = "<font color=blue>" + bookDTO.getTitle() + "</font>";
        // 위 같이 해도 되고 아래 같은 인라인 스타일로 할 수도 있다.
        strTitle = "<span style='color:#0000FF'>";
        strTitle += bookDTO.getTitle() + "</span>";

        txt_title.setText(
                HtmlCompat.fromHtml(
                    strTitle,HtmlCompat.FROM_HTML_MODE_LEGACY));


        // 글자색을 임의로 지정해봄(이렇게는 너무 복잡함. 이 방식이 안드로이드 권장방법이기는 함)
        /*
        Spannable span = (Spannable) txt_title.getText();
        span.setSpan(new ForegroundColorSpan(Color.BLUE),
                0,txt_title.getText().length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        */
    }

    @Override
    public int getItemCount() {
        // 제일 먼저 해줘야할 부분. 기본 returnd이 0이라 그냥 두면 아무것도 나오지 않게 되버림
        return bookList == null ? 0 : bookList.size();
    }

    /**
     * 각 데이터 item을 표현하기 위한 View 객체 생성하기
     */
    public static class BookViewHolder extends RecyclerView.ViewHolder{

        /**
         * DataBinding true 로 되어 있을때
         * book_item_view.xml layout 파일을 생성하면
         * 자동으로 선언되는 클래스
         *
         * DataBinding을 선언하면
         * layout.xml에 선언된 Component를 일일이 한개씩 세팅하지 않아도
         * binding 객체 한개만 세팅하면 나머지는 자동으로 같이 세팅이 된다
         */
        public BookItemViewBinding bookItemView;
        public BookViewHolder(@NonNull BookItemViewBinding bookItemViewBinding) {
            super(bookItemViewBinding.getRoot());
            bookItemView = bookItemViewBinding;
        }

        public void bind(BookDTO bookDTO) {
        }
    }
    
}

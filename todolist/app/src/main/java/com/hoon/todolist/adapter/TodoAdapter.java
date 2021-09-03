package com.hoon.todolist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoon.todolist.R;
import com.hoon.todolist.model.TodoVO;

import java.util.List;

/**
 * RecyclerView.Adapter 구현한 클래스
 * RecyvlerView에 데이터를 표현하고자 할때 사용하는
 *      Helper 클래스(도와주는 도구 클래스)
 */
public class TodoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<TodoVO> todoVOList;

    /**
     * 외부에서 todoVO 데이터 아이템을 List를 추가하고
     * 추가된 List는 RecyclerView를 통해서
     *      화면에 다시 그려지게 될 것이다
     */
    public void addTodoList(TodoVO todoVO) {
        // 메시지를 리스트에 추가하기
        todoVOList.add(todoVO);

        // RecyclerView에게 todoVOList가 변화 되었으니
        // 다시 화면에 그려라 라고 지시하기
        // todoVOList의 끝(size() - 1위치에 값이 추가 되었으니)에
        // 값이 추가되었으니 다시 그려라
        notifyItemInserted(todoVOList.size() -1);
    }

    /**
     * RecyclerView가 화면에 그릴 데이터들을 전달받을 통로
     * @param todoVOList
     */
    public TodoAdapter(List<TodoVO> todoVOList) {
        this.todoVOList = todoVOList;
    }

    /**
     * todo_item.xml파일을 읽어서 한개의 아이템을 화면에 그릴 준비
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /**
         * LayoutInflater.from().inflate(todo_item)
         *
         * todo_item.xml 파일은 한개의 파일이 화면 전체를 구성하지 않고
         * 여기에서는 RecyclerView 내부에 각각 데이터 아이템을 그릴
         * 도구로 사용이 된다
         * 이러한 layout은 setContentView()를 사용하기 않고
         * layoutInfalter.infalte() 함수를 사용하여 만든다
         *
         */
        View item_layout
                = LayoutInflater.from( parent.getContext() )
                .inflate(R.layout.todo_item,parent,false);
        TodoViewHolder viewHolder
                = new TodoViewHolder(item_layout);
        return viewHolder;
    }

    // todoVOList에서 한개의 데이터를 getter하여
    // todo_item.xml파일과 함께 rendering을 수행할 method
    @Override
    public void onBindViewHolder(@NonNull
                                             RecyclerView.ViewHolder holder, int position) {
        // 전체 todoVOList에서 현재 화면에 그릴 item추출하기
        TodoVO todoVO = todoVOList.get(position);
        TodoViewHolder todoViewHolder
                = (TodoViewHolder) holder;

        // todo_item.xml 의 TextView 객체에 데이터를 담기
        todoViewHolder.item_msg.setText(todoVO.getMsg());
    }

    /**
     * RecyclerView가 데이터들을 화면에 표시할때 참조하는 함수
     * @return
     */
    @Override
    public int getItemCount() {
        return todoVOList == null ? 0 : todoVOList.size();
    }


    // class 내부에 in class
    public static class TodoViewHolder
            extends RecyclerView.ViewHolder {

        public TextView item_msg;

        // 각 데이터를 표현하기 위한
        // todo_item.xml의 view 객체(한개의 TextView) 를
        // 초기화(생성) 하는 method
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            item_msg = itemView.findViewById(R.id.item_memo);
        }
    }


}

class MemosController < ApplicationController


    def index
        @memos = Memo.all
    end

    def show
        @memo = Memo.find(params[:id])
    end

end
